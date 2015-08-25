package org.vamdc.basecol.mapping;

import static org.junit.Assert.*;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.junit.Ignore;
import org.junit.Test;
import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.BasecolTest.dao.EnergyTablesLevels;
import org.vamdc.BasecolTest.dao.RefsArticles;

public class TestRestrictablesETable {
	ServerRuntime cayenneRuntime = new ServerRuntime("cayenne-BasecolTest.xml");
    ObjectContext context = cayenneRuntime.getContext();
    
    
	@Test
	@Ignore
	public final void testSourceYear() {
		int year=1989;
		Expression sel = ExpressionFactory.matchExp("toRefsGroups.toRefsArticles.year", year);
		SelectQuery query = new SelectQuery(EnergyTables.class,sel);
		for (Object etbl:context.performQuery(query)){
			assertTrue(etbl instanceof EnergyTables);
			
			System.out.println(((EnergyTables)etbl).getTitle());
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testStateEnergy() {
		Expression sel = ExpressionFactory.matchExp("energytablesLevelss.energy", 0);
		SelectQuery query = new SelectQuery(EnergyTables.class,sel);
		for (Object etbl:context.performQuery(query)){
			assertTrue(etbl instanceof EnergyTables);
			
			EnergyTables et = (EnergyTables) etbl;
			System.out.println(et.getTitle());
			/*for(EnergyTablesLevels etl : et.getEnergytablesLevelss()){
				System.out.println(etl.getEnergy()+" "+et.getToUnits().getDesignation()+" "+etl.getLevel());
			}*/
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testStateEnergyCol() {
		Expression sel = ExpressionFactory.matchExp("toEnergyTarget.energytablesLevelss.energy", 0);
		Expression sel1 = ExpressionFactory.matchExp("toEnergyCollider.energytablesLevelss.energy", 0);
		Expression sel2 = sel.orExp(sel1);
		SelectQuery query = new SelectQuery(Collisions.class,sel2);
		
		for (Object col:context.performQuery(query)){
			assertTrue(col instanceof Collisions);
			
			Collisions c = (Collisions) col;
			System.out.println(c.getTitle());
			/*for(EnergyTablesLevels etl : c.getToEnergyTables().getEnergytablesLevelss()){
				System.out.println(etl.getEnergy()+" "+c.getToEnergyTables().getToUnits().getDesignation()+" "+etl.getLevel());
			}*/
		}
			//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testAtomSymbol() {
		Expression sel = ExpressionFactory.matchExp("toElements.stoichiometricFormula", "He");
		SelectQuery query = new SelectQuery(EnergyTables.class,sel);
		for (Object et:context.performQuery(query)){
			assertTrue(et instanceof EnergyTables);
			
			EnergyTables et1 = (EnergyTables) et;
			System.out.println(et1.getTitle()+" "+et1.getToElements().getDesignation());
			/*for(EnergyTablesLevels etl : c.getToEnergyTables().getEnergytablesLevelss()){
				System.out.println(etl.getEnergy()+" "+c.getToEnergyTables().getToUnits().getDesignation()+" "+etl.getLevel());
			}*/
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testAtomSymbolCol() {
		Expression sel = ExpressionFactory.matchExp("toEnergyTarget.toElements.stoichiometricFormula", "He");
		Expression sel1 = ExpressionFactory.matchExp("toEnergyCollider.toElements.stoichiometricFormula", "He");
		Expression sel2 = sel.orExp(sel1);
		
		SelectQuery query = new SelectQuery(Collisions.class,sel2);
		query.addPrefetch("toEnergyTarget");
		query.addPrefetch("toEnergyCollider");
		query.addPrefetch("toEnergyTarget.toElements");
		query.addPrefetch("toEnergyCollider.toElements");
		
		for (Object col:context.performQuery(query)){
			assertTrue(col instanceof Collisions);
			
			Collisions col1 = (Collisions) col;
			System.out.println(col1.getTitle()+" a "+col1.getToEnergyTarget().getToElements().getDesignation());
			System.out.println(col1.getTitle()+" b "+col1.getToEnergyCollider().getToElements().getDesignation());
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testInchiKey() {
		Expression sel = ExpressionFactory.matchExp("toElements.inchiKey", "UFHFLCQGNIYNRP-UHFFFAOYSA-N");
		SelectQuery query = new SelectQuery(EnergyTables.class,sel);
		
		for (Object et:context.performQuery(query)){
			assertTrue(et instanceof EnergyTables);
			
			EnergyTables et1 = (EnergyTables) et;
			System.out.println(et1.getTitle()+" a "+et1.getToElements().getDesignation());
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testInchiKeyCol() {
		Expression sel = ExpressionFactory.matchExp("toEnergyTarget.toElements.inchiKey", "UFHFLCQGNIYNRP-UHFFFAOYSA-N");
		Expression sel1 = ExpressionFactory.matchExp("toEnergyCollider.toElements.inchiKey", "UFHFLCQGNIYNRP-UHFFFAOYSA-N");
		Expression sel2 = sel.orExp(sel1);
		
		SelectQuery query = new SelectQuery(Collisions.class,sel2);
		query.addPrefetch("toEnergyTarget");
		query.addPrefetch("toEnergyCollider");
		query.addPrefetch("toEnergyTarget.toElements");
		query.addPrefetch("toEnergyCollider.toElements");
		
		for (Object col:context.performQuery(query)){
			assertTrue(col instanceof Collisions);
			
			Collisions col1 = (Collisions) col;
			System.out.println(col1.getTitle()+" a "+col1.getToEnergyTarget().getToElements().getDesignation());
			System.out.println(col1.getTitle()+" b "+col1.getToEnergyCollider().getToElements().getDesignation());
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testMoleculeStateNuclearSpinIsomer(){
		Expression sel = ExpressionFactory.matchExp("toSymmetries.designation", "ortho");
		
		SelectQuery query = new SelectQuery(EnergyTables.class,sel);
		query.addPrefetch("toElements");//il permet de faire des jointures sur la table Elements, car il ne
										//sait pas que je vais appeler et1.getToElements()...
		
		for (Object et:context.performQuery(query)){
			assertTrue(et instanceof EnergyTables);
			
			EnergyTables et1 = (EnergyTables) et;
			System.out.println(et1.getTitle()+" a "+et1.getToElements().getDesignation());
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	@Ignore
	public final void testMoleculeStateNuclearSpinIsomerCol(){
		Expression sel = ExpressionFactory.matchExp("toEnergyTarget.toSymmetries.designation", "ortho");
		Expression sel1 = ExpressionFactory.matchExp("toEnergyCollider.toSymmetries.designation", "ortho");
		Expression sel2 = sel.andExp(sel1);
		SelectQuery query = new SelectQuery(Collisions.class,sel2);
		query.addPrefetch("toEnergyTarget");
		query.addPrefetch("toEnergyCollider");
		query.addPrefetch("toEnergyTarget.toElements");//il permet de faire des jointures sur la table Elements, car il ne
										//sait pas que je vais appeler et1.getToElements()...
		query.addPrefetch("toEnergyCollider.toElements");
		
		for (Object col:context.performQuery(query)){
			assertTrue(col instanceof Collisions);
			
			Collisions col1 = (Collisions) col;
			System.out.println(col1.getTitle()+" a "+col1.getToEnergyTarget().getToElements().getDesignation());
			System.out.println(col1.getTitle()+" b "+col1.getToEnergyCollider().getToElements().getDesignation());
		}
		//fail("Not yet implemented"); // TODO
	}
	
	@Test 
	public final void testEnvironmentTemperature(){
		Expression sel = ExpressionFactory.greaterExp("ratecoefficientss.temperature", 3000);
		
		SelectQuery query = new SelectQuery(Collisions.class,sel);
				
		for (Object col:context.performQuery(query)){
			assertTrue(col instanceof Collisions);
			
			Collisions col1 = (Collisions) col;
			System.out.println(col1.getTitle());
		}
		//fail("Not yet implemented"); // TODO
	}

}
