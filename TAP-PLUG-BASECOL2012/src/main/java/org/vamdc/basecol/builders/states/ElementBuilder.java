package org.vamdc.basecol.builders.states;

import java.util.List;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;
import org.vamdc.basecol.constants.ElementTypes;
import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.basecol.mapping.Restrictables;
import org.vamdc.basecol.xsams.Particle;
import org.vamdc.tapservice.api.RequestInterface;
import org.vamdc.dictionary.Requestable;
import org.vamdc.dictionary.VSSPrefix;
import org.vamdc.tapservice.vss2.LogicNode;


/*
 * Get element record, choose it's type, call corresponding molecule or atom or particle builder
 * 
 * 
 */

public class ElementBuilder {
	/*
	 * Put all elements matching their restrictors
	 * */
	@SuppressWarnings("unchecked")
	public static void addElementsByRestrictors(RequestInterface request){
		//Check if we are requested to return elements:
		if (!(request.checkBranch(Requestable.Atoms) ||
				request.checkBranch(Requestable.Molecules)||
				request.checkBranch(Requestable.Particles)||
				request.checkBranch(Requestable.Solids)) ) {
			return;
		}

		Expression etExpression = getExpression(request);
		
		SelectQuery etQuery=new SelectQuery(EnergyTables.class,etExpression);
		List<EnergyTables> etables = (List<EnergyTables>)request.getCayenneContext().performQuery(etQuery);
		
		for (EnergyTables eTable:etables){
			addElement(eTable,request);
		}
		
	}

	public static Expression getExpression(RequestInterface request) {
		//TODO: use also TARGET and COLLIDER prefixes
		//Query for energy tables:
		Expression result=null,collExpr=null,tgtExpr=null;
		//Check if we have target tree defined
		LogicNode target = request.getQuery().getPrefixedTree(VSSPrefix.TARGET, 0);
		
		
		if (target!=null)
			tgtExpr = Restrictables.queryMapper.mapTree(target,Restrictables.QUERY_ETABL);
		if (tgtExpr!=null){
			result = tgtExpr;
			
			//Check if we have collider tree defined		
			LogicNode collider = request.getQuery().getPrefixedTree(VSSPrefix.COLLIDER, 0);
			
			collExpr = Restrictables.queryMapper.mapTree(target,Restrictables.QUERY_ETABL);
			if (collider!=null && collExpr!=null)//If yes, add it also
				result = result.orExp(collExpr);
		}else{
			//No prefixes are defined, so sad, let's try unprefixed VSS1 mode
			result = Restrictables.queryMapper.mapTree(request.getRestrictsTree(),Restrictables.QUERY_ETABL);
		}
		return result;
	}
	
	public static void addElement(EnergyTables energyTable, RequestInterface request){
		
		if (!request.checkBranch(Requestable.Collisions))
			request.setLastModified(energyTable.getModificationDate());
		
		switch(energyTable.getToElements().getToElementTypes().getIdElementType()/*getElementRel().getIdElementType()*/){
		case ElementTypes.Atom:
			AtomicTypeBuilder.addAtom(energyTable, request);
			break;
		case ElementTypes.Molecule:
		case ElementTypes.MolecIonNegative:
		case ElementTypes.MolecIonPositive:
			MoleculeBuilder.addMolecule(energyTable, request);
			break;
		case ElementTypes.Particle:
			addParticle(energyTable, request);
			break;
		default:
			break;
		}
	}

	protected static void addParticle(EnergyTables itsenergytable, RequestInterface request) {
		if (request.checkBranch(Requestable.Particles))
			request.getXsamsManager().addElement(new Particle(itsenergytable));
	}



}
