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
import org.vamdc.basecol.xsams.Atom;
import org.vamdc.basecol.xsams.AtomState;
import org.vamdc.basecol.xsams.Source;
import org.vamdc.dictionary.Requestable;
import org.vamdc.tapservice.api.RequestInterface;
import org.vamdc.xsams.species.atoms.AtomType;
import org.vamdc.xsams.species.atoms.AtomicStateType;
import org.vamdc.xsams.util.IDs;
import org.vamdc.xsams.util.StateCore;

public class AtomicTypeBuilder {	
	
	@SuppressWarnings("unchecked")
	public static void addAtom(EnergyTables myetable, RequestInterface myrequest){
		if (!myrequest.checkBranch(Requestable.Atoms)) 
			return;
		String atomID = IDs.getSpecieID(myetable.getToElements().getIdElement().intValue());
		if (myrequest.getXsamsManager().getElement(atomID)==null)
		{//build atom description only in case we don't have it yet, in other case just add states
			AtomType myatom = new Atom(myetable.getToElements());
		
			//Add atom to XSAMS tree
			myrequest.getXsamsManager().addElement(myatom);
		}
		if(myrequest.checkBranch(Requestable.AtomStates)){
			/*Use explicit query with prefetch to fasten levels loading*/
			DataContext context = (DataContext)myrequest.getCayenneContext();
			Expression levelsspec = ExpressionFactory.matchExp("toEnergyTables.idEnergyTable",myetable.getIdEnergyTable());
			SelectQuery query = new SelectQuery(EnergyTablesLevels.class, levelsspec);
			query.addPrefetch("energytablesLevelsQuantumnumberss");

			//Load sources
			List<RefsGroups> refs=myetable.getRefsGroupsFromIdRefGroups(context);
			
			/*TODO:
			 * Here add restrictables processing
			 * */
			Collection<AtomicStateType> mystates = new ArrayList<AtomicStateType>();
			for (EnergyTablesLevels level :(List<EnergyTablesLevels>)context.performQuery(query)){
				StateCore statedata = new BasecolStateCore(myetable, level);
				AtomicStateType newstate = new AtomState(statedata);

				//Put all references
				//newstate.addSources(Source.getSources(myetable.getToRefsGroups()/*getReferenceRel()*/,myrequest.getXsamsManager(),false));
				newstate.addSources(Source.getSources(refs,myrequest.getXsamsManager(),false));
				
				newstate.setComments(myetable.getTitle());
				//Save level
				mystates.add(newstate);
			}
			//Add states to XSAMS tree
			myrequest.getXsamsManager().addStates(
					IDs.getSpecieID(myetable.getToElements().getIdElement().intValue()),
					mystates);
		}

	}
	
}
