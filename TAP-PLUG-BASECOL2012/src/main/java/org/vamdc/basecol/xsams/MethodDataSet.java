package org.vamdc.basecol.xsams;

import java.util.List;

import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.Fits;
import org.vamdc.xsams.XSAMSManager;
import org.vamdc.xsams.schema.MethodCategoryType;
import org.vamdc.xsams.schema.MethodType;
import org.vamdc.xsams.util.IDs;

public class MethodDataSet extends MethodType{

	public MethodDataSet(Collisions data){
		super();
		this.setMethodID(getMethodID(data));
		
		this.setCategory(MethodCategoryType.THEORY);
		
		List<Fits> fits = data.getFitss();
		if(fits!=null && fits.size()>0)
			this.setDescription("Accuracy: "+fits.get(0).getPrecis());
	}
	
	private static String getMethodID(Collisions data){
		return IDs.getMethodID((int)data.getIdCollision()/*getIdCollision().intValue()*/)+"D";
	}
	
	public static MethodType getMethod(Collisions data,XSAMSManager document){
		String id = getMethodID(data);
		MethodType result = document.getMethod(id);
		
		if (result==null){
			result=new MethodDataSet(data);
			document.addMethod(result);
		}
		
		return result;
	}

}
