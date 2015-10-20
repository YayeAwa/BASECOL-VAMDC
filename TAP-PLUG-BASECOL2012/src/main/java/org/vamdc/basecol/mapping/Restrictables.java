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
				//.addNewPath("symelementRel.elementRel.stoichiometricFormula")
				.addNewPath("toElements.stoichiometricFormula")//ETable
				//.addNewPath("partyRel.elementRel.stoichiometricFormula")
				.addNewPath("toEnergyParty.toElements.stoichiometricFormula")//collision
				.addNewPath("")
				);
		
		this.addKeywordMapper(
				new SpecieNameMapper(Restrictable.MoleculeStoichiometricFormula,
						new Byte(ElementTypes.Molecule),
						new Byte(ElementTypes.MolecIonNegative),
						new Byte(ElementTypes.MolecIonPositive))
				//.addNewPath("symelementRel.elementRel.stoichiometricFormula")
				.addNewPath("toElements.stoichiometricFormula")//ETable
				.addNewPath("toEnergyParty.toElements.stoichiometricFormula")
				.addNewPath("")
				);
		
		this.addKeywordMapper(
				new SpecieNameMapper(Restrictable.ParticleName,
						new Byte(ElementTypes.Particle))
				//.addNewPath("symelementRel.elementRel.stoichiometricFormula")
				//.addNewPath("partyRel.elementRel.stoichiometricFormula")
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
				//.addNewPath("symelementRel.elementRel.inchiRel.inchiKey")
				.addNewPath("toElements.inchiKey")
				//.addNewPath("partyRel.elementRel.inchiRel.inchiKey")
				.addNewPath("toEnergyParty.toElements.inchiKey")
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.MoleculeStateNuclearSpinIsomer)
				//.addNewPath("symelementRel.symmetryRel.designation")
				.addNewPath("toSymmetries.designation")
				//.addNewPath("partyRel.symmetryRel.designation")
				.addNewPath("toEnergyParty.toSymmetries.designation")
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.SourceYear)
				//.addNewPath("articleRel.year")
				.addNewPath("toRefsGroups.toRefsArticles.year")
				.addNewPath("year")
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.StateEnergy)
				//.addNewPath("levelsRel.energy")
				.addNewPath("energytablesLevelss.energy")//en partant de ETable
				//.addNewPath("partyETableRel.levelsRel.energy")
				.addNewPath("toEnergyTables.energytablesLevelss.energy")//en partant de collision
				.addNewPath("")
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.EnvironmentTemperature)
				.addNewPath("")
				//.addNewPath("myRateCoeffRel.temperature")
				.addNewPath("ratecoefficientss.temperature")
				.addNewPath("temperature")// en partant de RateCoefficient table
				);
		this.addKeywordMapper(
				new KeywordMapperImpl(Restrictable.IonCharge)
				//.addNewPath("symelementRel.elementRel.charge")
				.addNewPath("toElements.charge")
				//.addNewPath("partyRel.elementRel.charge")
				.addNewPath("toEnergyParty.toElements.charge")
				.addNewPath("")
				);
		
		
	}};
	
	
	
	
}
