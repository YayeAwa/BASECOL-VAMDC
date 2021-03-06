package org.vamdc.basecol.builders.states;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.BasecolTest.dao.EnergyTablesLevels;
import org.vamdc.BasecolTest.dao.RefsGroups;
import org.vamdc.basecol.xsams.MethodEtable;
import org.vamdc.basecol.xsams.MolecularState;
import org.vamdc.basecol.xsams.Molecule;
import org.vamdc.basecol.xsams.Source;
import org.vamdc.basecol.xsams.ZeroPointState;
import org.vamdc.dictionary.Requestable;
import org.vamdc.tapservice.api.RequestInterface;
import org.vamdc.xsams.XSAMSManager;
import org.vamdc.xsams.species.molecules.MolecularStateType;
import org.vamdc.xsams.species.molecules.MoleculeType;
import org.vamdc.xsams.util.IDs;
import org.vamdc.xsams.util.StateCore;

/*
 * Molecule type builder 
 * builds molecularstates
 */


public class MoleculeBuilder {
	public static void addMolecule(EnergyTables energytable, RequestInterface myrequest) {
		if (!myrequest.checkBranch(Requestable.Molecules)){
			return;
		}
		
		//Group energy tables by molecule
		String molecID = IDs.getSpecieID(energytable.getIdEnergyTable().intValue());

		if (myrequest.getXsamsManager().getElement(molecID)==null){	
			MoleculeType molecule = new Molecule(energytable);
			molecule.setSpeciesID(molecID);
			myrequest.getXsamsManager().addElement(molecule);
		}

		//Add states
		if (myrequest.checkBranch(Requestable.MoleculeStates)){

			myrequest.getXsamsManager().addStates(
					molecID, 
					buildMolecularStates(energytable,myrequest));
		}
	}

	@SuppressWarnings("unchecked")
	private static Collection<MolecularStateType> buildMolecularStates(EnergyTables eTable, RequestInterface request) {
		Collection<MolecularStateType> result = new ArrayList<MolecularStateType>();

		XSAMSManager document = request.getXsamsManager();
		
		/*Use explicit query with prefetch to fasten levels loading*/
		DataContext context = (DataContext)request.getCayenneContext();
		Expression levelsspec = ExpressionFactory.matchExp("toEnergyTables.idEnergyTable",eTable.getIdEnergyTable());
		SelectQuery query = new SelectQuery(EnergyTablesLevels.class, levelsspec);
		query.addPrefetch("energytablesLevelsQuantumnumberss");
		
		//Load sources
		List<RefsGroups> refs=eTable.getRefsGroupsFromIdRefGroups(context);
		System.out.println("et"+eTable.getIdEnergyTable()+"list "+refs.size());

		/*TODO:
		 * Here add restrictables processing
		 * */

		MolecularStateType zeropoint = null;
		MolecularStateType isomer = null;
		for (EnergyTablesLevels level :(List<EnergyTablesLevels>)context.performQuery(query)){
			StateCore state = new BasecolStateCore(eTable, level);
			
			if (document.getState(state.getId())!=null)
				break;//Skip creating states if they seem to exist in DB
			
			MolecularStateType newState = 
					new MolecularState(
							state,
							zeropoint,
							isomer,
							request.checkBranch(Requestable.MoleculeQuantumNumbers));

			//Set zero point as the first state
			if (zeropoint==null){
				if (newState.getMolecularStateCharacterisation().getStateEnergy().getValue().getValue() == 0.)
					zeropoint=newState;
				else {
					zeropoint=new ZeroPointState(state,request.checkBranch(Requestable.MoleculeQuantumNumbers));
					zeropoint.setStateID(IDs.getStateID(eTable.getIdEnergyTable().intValue(), 0));
					result.add(zeropoint);
					newState.getMolecularStateCharacterisation().getStateEnergy().setEnergyOrigin(zeropoint);
				}
			}
			
			if (isomer==null)
				isomer=newState;
			
			//Add source references
			//newState.addSources(Source.getSources(eTable.getToRefsGroups(),document,false));
			
			newState.addSources(Source.getSources(refs,document,false));
			
			//Add method
			newState.setMethodRef(MethodEtable.getMethod(eTable.getExp(), document));
			
			//Save level
			result.add(newState);
		}
		return result;
	}
}
