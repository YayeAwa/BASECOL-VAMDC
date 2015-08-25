package org.vamdc.basecol.xsams;

import java.util.List;

import org.vamdc.BasecolTest.dao.RefsArticlesAuthors;
import org.vamdc.BasecolTest.dao.RefsAuthors;
import org.vamdc.xsams.sources.AuthorsType;

public class Authors extends AuthorsType{
	
	public Authors(List<RefsArticlesAuthors> list){
		for (RefsArticlesAuthors myauthor :list){
			addAuthor(myauthor.getToRefsAuthors().getFirstName()+" "+myauthor.getToRefsAuthors().getSurname());
		}
	}
	
}
