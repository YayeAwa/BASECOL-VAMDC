package org.vamdc.basecol.xsams;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.vamdc.BasecolTest.dao.RefsArticles;
import org.vamdc.BasecolTest.dao.RefsGroups;
import org.vamdc.xsams.XSAMSManager;
import org.vamdc.xsams.schema.SourceCategoryType;
import org.vamdc.xsams.schema.SourceType;
import org.vamdc.xsams.util.IDs;

public class Source extends SourceType{

	public Source(RefsArticles article){

		setSourceID(IDs.getSourceID(article.getIdArticle().intValue()));
		setCategory(SourceCategoryType.fromValue(article.getToRefsJournals().getCategory()));

		setSourceName(article.getToRefsJournals().getSmallName());

		//Year
		setYear(article.getYear().intValue());

		//Authors
		setAuthors(new Authors(article.getRefsArticlesAuthorss()));				
		//Title
		setTitle(article.getTitle());	
		//URL
		setUniformResourceIdentifier(article.getUrl());
		//Volume
		setVolume(article.getVolume());
		//Pages
		String pagesbe = article.getPage();
		if (pagesbe!=null){

			if (pagesbe.contains("-")){
				fillPages(pagesbe,"-");
			}else if (pagesbe.contains("\\+")){
				fillPages(pagesbe,"+");
			}
		};

	}

	private void fillPages(String pagesStr,String separator) {
		String[] pages = pagesStr.split(separator);
		setPageBegin(pages[0]);
		if (pages.length>1)
			for (int i=1;i<pages.length;i++){
				String part = pages[i].trim();
				if (part.length()>0){
					setPageEnd(part);
					break;
				}
			}
	}

	/**
	 * 
	 * @param referenceRel Collection of reference records from database model
	 * @param myrequest Request data
	 * @param filterSource add only records that have 'isSource' flag set if true, all references otherwise
	 * @return a list of XSAMS source records, to attach to PrimaryType.
	 */
	public static Collection<SourceType> getSources(
			List<RefsGroups> referenceRel, XSAMSManager document, boolean filterSource) {
		//Here sources will be added
		HashMap<String,SourceType> ret = new HashMap<String,SourceType> ();
		//ArrayList<SourceType> result = new ArrayList<SourceType>();

		/*always add database self-reference*/
		//result.add(document.getSource(IDs.getSourceID(0)));
		ret.put(IDs.getSourceID(0), document.getSource(IDs.getSourceID(0)));
		
		if (referenceRel==null)
			return ret.values();

		/*Add all sources that are stated as 'isSource'*/
		for (RefsGroups myref:referenceRel){
			RefsArticles article = myref.getToRefsArticles();
			if (article!=null && (myref.getIsSource() || !filterSource)){
				//Check if source with this ID was already referenced:
				String sid=IDs.getSourceID(article.getIdArticle().intValue());
				SourceType source = document.getSource(sid); 
				if (source == null){//If not, create and add it:
					source = new Source(article);
					document.addSource(source);
				}
				//Now, add source record to the collection of source references
				ret.put(sid,source);
			}
		}
		//return result;
		return ret.values();
	}

}
