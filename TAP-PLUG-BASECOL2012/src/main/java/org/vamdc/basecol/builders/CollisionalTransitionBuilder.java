package org.vamdc.basecol.builders;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.vamdc.basecol.builders.states.ElementBuilder;
import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.RateCoefficients;
import org.vamdc.BasecolTest.dao.LevelGroups;
import org.vamdc.basecol.mapping.Restrictables;
import org.vamdc.BasecolTest.misc.RatesTemperatureMap;
import org.vamdc.basecol.xsams.Collision;
import org.vamdc.tapservice.api.RequestInterface;
import org.vamdc.dictionary.Requestable;
import org.vamdc.dictionary.VSSPrefix;
import org.vamdc.tapservice.vss2.LogicNode;
import org.vamdc.tapservice.vss2.Prefix;
import org.vamdc.xsams.XSAMSManager;

/**
 * 
 * Collisional transition branch builder
 * builds rate coefficients table for each group of energy levels
 */
public class CollisionalTransitionBuilder {



	//Add collision by base record
	public static boolean addCollision(Collisions data,RequestInterface request){


		//Check if we need to build collisions at all
		if (!request.checkBranch(Requestable.Collisions)) return false;
		
		//We will add here all "collisions" for this group:
		//Build filter expression for rate coefficients
		Expression rcexpr = ExpressionFactory.matchExp("toCollisions.idCollision",data.getIdCollision());
		
		//Build limit expression
		Expression myExpression =
				Restrictables.queryMapper.mapTree(request.getRestrictsTree(), Restrictables.RATES);

		if (myExpression != null) rcexpr=rcexpr.joinExp(0, myExpression);
		else System.out.println(" MyExpressions est null");

		//Build states for collider and target
		if (request.checkBranch(Requestable.Atoms)
				|| request.checkBranch(Requestable.Molecules)
				|| request.checkBranch(Requestable.Particles) 
				|| request.checkBranch(Requestable.Solids)
				){
			ElementBuilder.addElement(data.getToEnergyCollider(), request);
			ElementBuilder.addElement(data.getToEnergyTarget(), request);
		}

		
		XSAMSManager xsamsroot = request.getXsamsManager();

		//Load levelgroups of the collision
		Map<Long,LevelGroups> levelmap=new TreeMap<Long,LevelGroups>();
		for (LevelGroups lg:data.getLevelgroupss()){
			levelmap.put(lg.getIdLevelGroup(), lg);
		}
		
		for (RatesTemperatureMap rates:RateCoefficients.getTempDependency((DataContext)request.getCayenneContext(), rcexpr)){
			//System.out.println("ratecoeff levels"+keys.fCLevel+keys.fTLevel+keys.iCLevel+keys.iTLevel);


			if (!xsamsroot.addProcess(new Collision(xsamsroot,data,rates,levelmap)))
				return false;
		}
		
		request.setLastModified(data.getModificationDate());
		
		return true;
	}

	//Add collisions by restrictions
	@SuppressWarnings("unchecked")
	public static void addCollisions(RequestInterface myrequest) {

		Expression myExpression = getCayenneExpression(myrequest);

		if (myExpression!=null){
			myExpression=myExpression.andExp(ExpressionFactory.matchExp("isVisible",1));
			SelectQuery query=new SelectQuery(Collisions.class,myExpression);
			List<Collisions> collisions = (List<Collisions>) myrequest.getCayenneContext().performQuery(query);
			
			for (Collisions mycollision:collisions){
				if (!addCollision(mycollision,myrequest))
					break;
			}
			
		};

	}

	public static Expression getCayenneExpression(RequestInterface myrequest) {
		//Build limits expression
		Expression result=null,collExpr=null;

		LogicNode target=null;
		LogicNode collider=null;
		//Fill in subtrees for target and collider
		for(Prefix pref:myrequest.getQuery().getPrefixes()){
			if(pref.getPrefix()==VSSPrefix.TARGET){
				target =myrequest.getQuery().getPrefixedTree(VSSPrefix.TARGET, 0);
			}
			else if (pref.getPrefix()==VSSPrefix.COLLIDER){
				collider = myrequest.getQuery().getPrefixedTree(VSSPrefix.COLLIDER, 0);
			}
			else if (pref.equals(new Prefix(VSSPrefix.REACTANT,0))){
				target=myrequest.getQuery().getPrefixedTree(VSSPrefix.REACTANT, 0);
			}
			else if (pref.equals(new Prefix(VSSPrefix.REACTANT,1))){
				collider=myrequest.getQuery().getPrefixedTree(VSSPrefix.REACTANT, 1);
			}
		}

		//Try to map target
		if (target!=null)
			result = Restrictables.queryMapper.mapAliasedTree(
					target, 
					Restrictables.QUERY_COLLISION, 
					Restrictables.PARTY,
					Restrictables.TARGET);

		//Try to map collider
		if (collider!=null)
			collExpr =  Restrictables.queryMapper.mapAliasedTree(
					collider, 
					Restrictables.QUERY_COLLISION, 
					Restrictables.PARTY,
					Restrictables.COLLIDER);

		//Join target and collider
		if (collExpr!=null){
			if (result!=null)
				result = result.andExp(collExpr);
			else 
				result=collExpr;
		}

		if (result!=null){//We have target/collider restriction, let's also process non-prefixed keywords:
			LogicNode unprefixed = myrequest.getQuery().getPrefixedTree(null,0);
			Expression unpref=null;
			if (unprefixed!=null)
				unpref = Restrictables.queryMapper.mapAliasedTree(
					unprefixed, 
					Restrictables.QUERY_COLLISION, 
					Restrictables.PARTY,
					Restrictables.TARGET);
			if (unpref!=null)
				result = result.andExp(unpref);
			
		}else{
			//No prefixes are defined, so sad, let's try unprefixed VSS1 mode
			Expression unpref = Restrictables.queryMapper.mapAliasedTree(
					myrequest.getRestrictsTree(), 
					Restrictables.QUERY_COLLISION, 
					Restrictables.PARTY,
					Restrictables.TARGET);
			result = Restrictables.queryMapper.mapAliasedTree(
					myrequest.getRestrictsTree(), 
					Restrictables.QUERY_COLLISION,
					Restrictables.PARTY,
					Restrictables.COLLIDER);
			if (unpref!=null && result!=null)
				result = result.orExp(unpref);
			else 
				result=unpref;
		}
		return result;
	}

}
