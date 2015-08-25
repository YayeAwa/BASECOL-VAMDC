package org.vamdc.basecol.xsams;

import static org.junit.Assert.*;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.SelectQuery;
import org.junit.Test;
import org.vamdc.BasecolTest.dao.RefsArticles;
import org.vamdc.xsams.schema.AuthorType;

public class SourceTest {
	//DataContext context = DataContext.createDataContext();
	//démarrer la connexion
	ServerRuntime cayenneRuntime = new ServerRuntime("cayenne-BasecolTest.xml");
    ObjectContext context = cayenneRuntime.getContext();
    
	@Test
	public void testBibSourceConstructor(){
		//TODO: temp fix to exclude journal=0
		//Expression sel = ExpressionFactory.noMatchExp("journalID", 0);
		System.out.println("test");
		SelectQuery query = new SelectQuery(RefsArticles.class);
		//ajooute toutes les données liées 
		query.addPrefetch("toRefsJournals");
		query.addPrefetch("refsArticlesAuthorss");
		query.addPrefetch("refsArticlesAuthorss.toRefsAuthors");
		
		for (Object source:context.performQuery(query)){
			assertTrue(source instanceof RefsArticles);
			Source src = new Source((RefsArticles) source);
			System.out.println(src.getTitle());
			for (AuthorType author: src.getAuthors().getAuthors())
				System.out.println(author.getName());
			assertTrue (src.getTitle().length()>0);
			
			
			//testPagesBeginEnd(src);
			
		}
	}

	private void testPagesBeginEnd(Source src) {
		Integer test;
		if (src.getPageBegin()!=null && src.getPageBegin().length()>0)
			test = Integer.valueOf(src.getPageBegin());
		if (src.getPageEnd()!=null && src.getPageEnd().length()>0)
			test = Integer.valueOf(src.getPageEnd());
	}
}
