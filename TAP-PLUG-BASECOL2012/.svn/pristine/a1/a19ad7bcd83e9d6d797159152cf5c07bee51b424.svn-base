package org.vamdc.basecol.xsams;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.vamdc.tapservice.api.RequestInterface;
import org.vamdc.xsams.schema.SourceCategoryType;
import org.vamdc.xsams.sources.AuthorsType;
import org.vamdc.xsams.sources.SourceType;
import org.vamdc.xsams.util.IDs;

/**
 * Self reference
 * @author doronin
 *
 */
public class SelfSource extends SourceType{
	
	public SelfSource(RequestInterface myRequest){
		super();
		
		setSourceID(IDs.getSourceID(0));
		setCategory(SourceCategoryType.DATABASE);
		setSourceName("BASECOL database");
		setAuthors(new AuthorsType("M.-L. Dubernet",","));
		setUniformResourceIdentifier("http://basecol.obspm.fr");
		setComments("QUERY "+myRequest.getQueryString());
		
		Calendar now = new GregorianCalendar();
		setYear(now.get(Calendar.YEAR));
		setProductionDate(now.getTime());
	}
	
}
