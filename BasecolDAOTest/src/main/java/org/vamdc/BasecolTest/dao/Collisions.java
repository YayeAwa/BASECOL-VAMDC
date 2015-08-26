package org.vamdc.BasecolTest.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.vamdc.basecolTest.dao.auto._Collisions;

public class Collisions extends _Collisions {
	
	public List<RefsGroups> getRefsGroupsFromIdRefGroups(DataContext context){
		
		RefsGroups refsGroups = this.getToRefsGroups();
		
		if(refsGroups!=null){
			SelectQuery query = prepareRefsQuery(refsGroups);
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
	
	public List<RefsGroups> getRefsGroupsFromIdRefPES(DataContext context){
		RefsGroups refsPES = this.getToRefsPES();

		if(refsPES!=null){
			SelectQuery query = prepareRefsQuery(refsPES);
			return context.performQuery(query);
		}  
		return Collections.EMPTY_LIST;
	}
	
	public List<RefsGroups> getRefsGroupsFromIdRefMethods(DataContext context){
		RefsGroups refsMethods = this.getToRefsMethod();
		
		if(refsMethods!=null){
			SelectQuery query = prepareRefsQuery(refsMethods);
			return context.performQuery(query);
		}  
		return Collections.EMPTY_LIST;
	}
	
	public List<RefsGroups> getRefsGroupsFromIdRefMass(DataContext context){
		RefsGroups refsMass = this.getToRefsReduMass();
		
		if(refsMass!=null){
			SelectQuery query = prepareRefsQuery(refsMass);
			return context.performQuery(query);
		}  
		return Collections.EMPTY_LIST;
	}
	
}
