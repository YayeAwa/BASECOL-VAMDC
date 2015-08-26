package org.vamdc.basecol.xsams;

import java.util.List;
import java.util.Map;

import org.apache.cayenne.access.DataContext;
import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.LevelGroups;
import org.vamdc.BasecolTest.dao.RefsGroups;
//import org.vamdc.BasecolTest.misc.LevelSet;
import org.vamdc.BasecolTest.misc.RatesTemperatureMap;
import org.vamdc.xsams.XSAMSManager;
import org.vamdc.xsams.common.DataSetType;
import org.vamdc.xsams.common.DataSetsType;
import org.vamdc.xsams.process.collisions.CollisionalProcessClassType;
import org.vamdc.xsams.process.collisions.CollisionalTransitionType;
import org.vamdc.xsams.schema.SpeciesStateRefType;
import org.vamdc.xsams.util.IDs;

public class Collision extends CollisionalTransitionType{


	public Collision(
			
			XSAMSManager document,
			Collisions data,
			RatesTemperatureMap rates, Map<Long, LevelGroups> levelmap,
			List<RefsGroups> allRefs,List<RefsGroups> methodRefs){

		this.setId(IDs.getID('P',"C"+data.getIdCollision()+levelmap.get(rates.getLevelGroupID()).getID()));

		//List<RefsGroups> allRefs = data.getToRefsGroups();
		/*allRefs.addAll(data.getToRefsMethod());
		allRefs.addAll(data.getToRefsPES());
		allRefs.addAll(data.getToRefsReduMass());*/
		
		this.addSources(Source.getSources(allRefs,document,true));

		this.setMethodRef(MethodCollision.getMethod( data, document,allRefs));
		
		this.setComments(data.getTitle());

		int targetETable = data.getToEnergyTarget().getIdEnergyTable().intValue();
		int colliderETable = data.getToEnergyCollider().getIdEnergyTable().intValue();
		//LevelSet levels = rates.getMylevels();
		LevelGroups lg=levelmap.get(rates.getLevelGroupID());
		
		this.getReactants().add(
				getRef(document, targetETable, lg.getToETLInitTarget().getLevel()));
		this.getReactants().add(
				getRef(document,colliderETable, lg.getToETLInitCollider().getLevel()));
		this.getProducts().add(
				getRef(document,targetETable,lg.getToETLFinalTarget().getLevel()));
		this.getProducts().add(
				getRef(document,colliderETable, lg.getToETLFinalCollider().getLevel()));

		DataSetType ratesDataSet = new RateCoefficientDataSet(rates);
		
		ratesDataSet.getTabulatedDatas().get(0).setMethodRef(MethodDataSet.getMethod(data,document));
		
		this.setDataSets(
				new DataSetsType(ratesDataSet));

		this.setProcessClass(new CollisionalProcessClassType("inel"));
		

	}

	private SpeciesStateRefType getRef(XSAMSManager document, int refETable, int refLevel) {
		 SpeciesStateRefType result= document.getStateRef(IDs.getStateID(refETable,refLevel));
		 if (result==null || result.getSpeciesRef()==null)
			 result = document.getSpeciesRef(IDs.getSpecieID(refETable));
		 return result;
	}
}
