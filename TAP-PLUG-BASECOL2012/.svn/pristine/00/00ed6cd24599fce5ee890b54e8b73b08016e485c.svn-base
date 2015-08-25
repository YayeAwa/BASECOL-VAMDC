package org.vamdc.basecol.xsams;

import org.vamdc.xsams.XSAMSManager;
import org.vamdc.xsams.schema.MethodCategoryType;
import org.vamdc.xsams.schema.MethodType;
import org.vamdc.xsams.util.IDs;

public class MethodEtable extends MethodType{
	
	public MethodEtable(String experiment){
		super();
		
		this.setDescription("Energy table origin");
		
		if (experiment.equals("no"))
			this.setCategory(MethodCategoryType.THEORY);
		else 
			this.setCategory(MethodCategoryType.EXPERIMENT);
		
		this.setMethodID(getMethodID(experiment));
	}

	private static String getMethodID(String experiment){
		return IDs.getID('M', "exp"+experiment);
	}
	
	public static MethodType getMethod(String experiment,XSAMSManager document){
		String id = getMethodID(experiment);
		MethodType result = document.getMethod(id);
		
		if (result==null){
			result=new MethodEtable(experiment);
			document.addMethod(result);
		}
		
		return result;
	}
	
}
