package org.vamdc.BasecolTest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.CayenneException;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.access.ResultIterator;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;
import org.apache.cayenne.query.SortOrder;
import org.vamdc.BasecolTest.dao.RateCoefficients;
import org.vamdc.BasecolTest.misc.RatesTemperatureMap;
import org.vamdc.basecolTest.dao.auto._RateCoefficients;

public class RateCoefficients extends _RateCoefficients {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ResultIterator getSorted(DataContext context, Expression limits) throws CayenneException{
		SelectQuery rcsel = new SelectQuery(RateCoefficients.class,limits);
		rcsel.setStatementFetchSize(1000);
		rcsel.addOrdering("toLevelGroups", SortOrder.ASCENDING);
		rcsel.addOrdering("temperature", SortOrder.ASCENDING);
		//rcsel.addPrefetch("toLevelGroups");
		return context.performIteratedQuery(rcsel);
	}
	
	@SuppressWarnings("unchecked")
	public static List<RatesTemperatureMap> getTempDependency(DataContext context, Expression limits){
		List<RatesTemperatureMap> result = new ArrayList<RatesTemperatureMap>();
		//Array for temp->ratecoeff data
		RatesTemperatureMap mydata = null;
		ResultIterator it = null;
		try{
			//for (RateCoefficients dataRecord:RateCoefficients.getSorted(context, collision, limits)){
			it = RateCoefficients.getSorted(context, limits);
			while(it.hasNextRow()) {
				//dataRecord = (RateCoefficients) it.nextRow();
				Map<String,Object> row = (Map<String,Object>) it.nextRow();
				long ilg=(Long)row.get("idLevelGroup");
				//If we just started or got new level, save it
				if (mydata==null || mydata.getLevelGroupID()!=ilg) {
					mydata = new RatesTemperatureMap(ilg);
					result.add(mydata);
				}
				//Go on putting datapoints
				mydata.addPoint((Double)row.get("temperature"), (Double)row.get("data"));
			}
		}catch(CayenneException ex) {
			   ex.printStackTrace();
		}finally {
		   try {
		      // explicit closing of the iterator is required !!!
		      if (it!=null) it.close();
		   }
		   catch(CayenneException closeEx) {
		       closeEx.printStackTrace();
		   }
		}

		return result;
	}
}
