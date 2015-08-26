package org.vamdc.BasecolTest.dao;

import java.util.Collections;
import java.util.List;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.vamdc.basecolTest.dao.auto._EnergyTables;

public class EnergyTables extends _EnergyTables {

	public List<RefsGroups> getRefsGroupsFromIdRefGroups(DataContext context){
		
		if(this.getToRefsGroups()!=null){
			SelectQuery query = prepareRefsQuery(this.getToRefsGroups());
			return context.performQuery(query);
		}
        
		return Collections.EMPTY_LIST;
		
	}
	private SelectQuery prepareRefsQuery(RefsGroups refsGroups) {
		Long idRefGroup = refsGroups.getIdRefGroup();
		Expression exp = ExpressionFactory.matchExp("idRefGroup",idRefGroup);
		SelectQuery query = new SelectQuery(RefsGroups.class,exp);
		query.addPrefetch("toRefsArticles");
		query.addPrefetch("toRefsArticles.refsArticlesAuthorss");
		query.addPrefetch("toRefsArticles.toRefsJournals");
		return query;
	}
}
