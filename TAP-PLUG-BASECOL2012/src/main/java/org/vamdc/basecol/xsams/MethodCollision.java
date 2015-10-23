package org.vamdc.basecol.xsams;

import java.util.List;

import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.RefsGroups;
import org.vamdc.xsams.XSAMSManager;
import org.vamdc.xsams.schema.MethodCategoryType;
import org.vamdc.xsams.schema.MethodType;
import org.vamdc.xsams.util.IDs;

public class MethodCollision extends MethodType{

	public MethodCollision( Collisions data,XSAMSManager document,List<RefsGroups> methodrefs){
		super();
		
		this.addSources(Source.getSources(methodrefs, document, false));
		
		this.setComments("Recommended: "+data.getRecommended());
		
		this.setCategory(MethodCategoryType.THEORY);
		
		this.setMethodID(getMethodID(data));
		
		
		StringBuilder descr = new StringBuilder();
		
		appendDescr(descr,"General",data.getComment());
		
		appendDescr(descr,"PES",data.getPesComment());
		
		appendDescr(descr,"Dyna_calc:Method",data.getMethodComment());
		appendDescr(descr,"Dyna_calc:BasisSet",data.getBasisSet());
		appendDescr(descr,"Dyna_calc:RangeOfEnergies",data.getRangeOfEnergy());
		
		this.setDescription(descr.toString());

	}
	
	private void appendDescr(StringBuilder output,String fieldName,String fieldValue){
		if (verify(fieldValue))
			output.append(fieldName).append("=").append(fieldValue).append(";\n");
	}
	
	private boolean verify(String field){
		return (field!=null && field.length()>0);
	}
	
	private static String getMethodID(Collisions data){
		return IDs.getMethodID((int)data.getIdCollision());
	}
	
	public static MethodType getMethod(Collisions data,XSAMSManager document,List<RefsGroups> methodrefs){
		String id = getMethodID(data);
		MethodType result = document.getMethod(id);
		
		if (result==null){
			result=new MethodCollision(data,document,methodrefs);
			document.addMethod(result);
		}
		
		return result;
	}
	
}
