package org.vamdc.basecol.mapping;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.vamdc.dictionary.Restrictable;
import org.vamdc.tapservice.querymapper.KeywordMapperImpl;
import org.vamdc.tapservice.vss2.RestrictExpression;

public class SpecieNameMapper extends KeywordMapperImpl{

	private Object[] elementTypes;
	
	public SpecieNameMapper(Restrictable key,Object... elementTypes) {
		super(key);
		this.elementTypes = elementTypes;
	}

	@Override
	protected Expression buildExpression(RestrictExpression restrictor,String pathSpec){
		Expression result = super.buildExpression(restrictor, pathSpec);
		
		
		if (result!=null && elementTypes!=null && elementTypes.length>0){
			String elementTypePath = pathSpec.replace("stoichiometricFormula", "idElementType");
			result=result.andExp(ExpressionFactory.inExp(elementTypePath,elementTypes));
		}
		
		return result;
		
	}
	
}
