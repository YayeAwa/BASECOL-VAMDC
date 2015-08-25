package org.vamdc.basecol.builders;


import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


import org.vamdc.basecol.builders.states.ElementBuilder;
import org.vamdc.basecol.mapping.Restrictables;
import org.vamdc.basecol.xsams.SelfSource;
import org.vamdc.dictionary.Restrictable;
import org.vamdc.tapservice.api.DatabasePlugin;
import org.vamdc.tapservice.api.RequestInterface;
import org.vamdc.dictionary.HeaderMetrics;
import org.vamdc.tapservice.vss2.LogicNode;
import org.vamdc.tapservice.vss2.RestrictExpression;

public class OutputBuilder implements DatabasePlugin{

	
	@Override
	public void buildXSAMS(RequestInterface myrequest) {
		/*always add database self-reference*/
		myrequest.getXsamsManager().addSource(new SelfSource(myrequest));
		
		if (myrequest.isValid() && checkRequest(myrequest)){
			ElementBuilder.addElementsByRestrictors(myrequest);//Put some elements
			CollisionalTransitionBuilder.addCollisions(myrequest);//Put collisions data
		};
	}
	
	//Do some checks on a query that doesn't require database access.
	private boolean checkRequest(RequestInterface myrequest) {
		//Check that if we have CollisionCode, it is "inel", otherwise just exit.
		List<Restrictable> collcode = new ArrayList<Restrictable>();
		collcode.add(Restrictable.CollisionCode);
		LogicNode ccode = myrequest.getQuery().getFilteredTree(collcode);
		if (ccode!=null){
			RestrictExpression code = (RestrictExpression) ccode;
			return "inel".equalsIgnoreCase((String) code.getValue());
		}
		return true;
	}
	
	@Override
	public Collection<Restrictable> getRestrictables() {
		return Restrictables.queryMapper.getRestrictables();
	}
	@Override
	public String getErrorMessage() {
		return "";
	}
	@Override
	public boolean isAvailable() {
		return true;
	}
	
	@Override
	public Map<HeaderMetrics, Object> getMetrics(RequestInterface request) {
		if (request.isValid() && checkRequest(request)){
			return Metrics.estimate(request);
		}
		return Collections.emptyMap();
	}
}
