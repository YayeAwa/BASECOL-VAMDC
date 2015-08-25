package org.vamdc.basecol.mapping;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.vamdc.dictionary.Restrictable;
import org.vamdc.tapservice.querymapper.KeywordMapperImpl;
import org.vamdc.tapservice.vss2.RestrictExpression;

public class CollisionCodeMapper extends KeywordMapperImpl{

	public CollisionCodeMapper(Restrictable key) {
		super(key);
	}
	
	@Override
	protected Expression buildExpression(RestrictExpression restrictor,String pathSpec){
		for (Object value: restrictor.getValues()){
			if (value instanceof String && "inel".contains((String) value))
				return ExpressionFactory.expTrue();
		}
		return ExpressionFactory.expFalse();
	}

}
