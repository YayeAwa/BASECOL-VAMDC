package org.vamdc.basecol.mapping;

import org.vamdc.basecol.constants.ElementTypes;
import org.vamdc.dictionary.Restrictable;
import org.vamdc.tapservice.querymapper.QueryMapper;
import org.vamdc.tapservice.querymapper.QueryMapperImpl;
import org.vamdc.tapservice.querymapper.KeywordMapperImpl;

/*
 * Here we put all supported restrictables
 * VOSICapabilities gets them from here also!
 * */
public class Restrictables {
	
	public final static int QUERY_ETABL=0;
	public final static int QUERY_COLLISION=1;
	public final static int RATES=2;
	public final static String PARTY="Party";
	public final static String TARGET="Target";
	public final static String COLLIDER="Collider";
	
	/**
	 * Query index 0 must have path relevant from EnergyTable,
	 * query index 1 gives restriction on the Collision table, here "Party" will be replaced with "Target" or "Collider"
	 *    depending on the restrictable prefixes
	 */
	public final static QueryMapper queryMapper= new QueryMapperImpl(){{
		this.addKeywordMapper(
				new SpecieNameMapper(Restrictable.AtomSymbol,
						new Byte(ElementTypes.Atom))
				.addNewPath("toElements.stoichiometricFormula")//ETable
				.addNewPath("toEnergyParty.toElements.stoichiometricFormula")//collision
				.addNewPath("")
				);
		
		this.addKeywordMapper(
				new SpecieNameMapper(Restrictable.MoleculeStoichiometricFormula,
						new Byte(ElementTypes.Molecule),
						new Byte(ElementTypes.MolecIonNegative),
						new Byte(ElementTypes.MolecIonPositive))
				.addNewPath("toElements.stoichiometricFormula")//ETable
				.addNewPath("toEnergyParty.toElements.stoichiometricFormula")
				.addNewPath("")
				);
		
		this.addKeywordMapper(
				new SpecieNameMapper(Restrictable.ParticleName,
						new Byte(ElementTypes.Particle))
				.addNewPath("toElements.stoichiometricFormula")//ETable
				.addNewPath("toEnergyParty.toElements.stoichiometricFormula")
				.addNewPath("")
				);
		
		this.addKeywordMapper(
				new CollisionCodeMapper(Restrictable.CollisionCode)
				.addNewPath("").addNewPath("")
				.addNewPath("")//We need to have same paths count even for dummy mappers
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.InchiKey)
				.addNewPath("toElements.inchiKey")
				.addNewPath("toEnergyParty.toElements.inchiKey")
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.MoleculeStateNuclearSpinIsomer)
				.addNewPath("toSymmetries.designation")
				.addNewPath("toEnergyParty.toSymmetries.designation")
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.SourceYear)
				.addNewPath("toRefsGroups.toRefsArticles.year")
				.addNewPath("year")
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.StateEnergy)
				.addNewPath("energytablesLevelss.energy")//en partant de ETable
				.addNewPath("toEnergyTables.energytablesLevelss.energy")//en partant de collision
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.EnvironmentTemperature)
				.addNewPath("")
				.addNewPath("ratecoefficientss.temperature")
				.addNewPath("temperature")// en partant de RateCoefficient table
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.IonCharge)
				.addNewPath("toElements.charge")
				.addNewPath("toEnergyParty.toElements.charge")
				.addNewPath("")
				);
		
		
	}};
	
	
	
	
}
