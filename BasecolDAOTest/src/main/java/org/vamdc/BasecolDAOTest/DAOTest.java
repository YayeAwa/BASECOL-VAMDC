package org.vamdc.BasecolDAOTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.CollisionsProcessus;
import org.vamdc.BasecolTest.dao.Elements;

/**
 * Hello world!
 *
 */
public class DAOTest 
{
    public static void main( String[] args )
    {
    	//démarrer la connexion
    	ServerRuntime cayenneRuntime = new ServerRuntime("cayenne-BasecolTest.xml");
        ObjectContext context = cayenneRuntime.getContext();
        
        //faire un select 
        SelectQuery query = new SelectQuery(Elements.class);
        @SuppressWarnings("unchecked")
		List<Elements> elts = context.performQuery(query);
        for (Elements elt : (ArrayList<Elements>)elts){
        	System.out.println("Design "+elt.getDesignation());
        }
        
        Expression e0 = ExpressionFactory.matchExp("collisionsProcessuses.toProcessus.idProcessus",4);
        SelectQuery q0 = new SelectQuery(Collisions.class,e0);
        List<Collisions> cps = context.performQuery(q0);
        for (Collisions elt : (ArrayList<Collisions>)cps){
        	System.out.println("Colll "+elt.getTitle()+" "+elt.getIdCollision());
        }
    }
}
