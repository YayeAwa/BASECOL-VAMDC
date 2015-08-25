package org.vamdc.basecol.xsams;

import org.vamdc.BasecolTest.dao.Elements;
import org.vamdc.BasecolTest.dao.EnergyTables;
//import org.vamdc.BasecolTest.dao.Inchi;
import org.vamdc.xsams.common.DataType;
import org.vamdc.xsams.species.molecules.MolecularChemicalSpeciesType;
import org.vamdc.xsams.species.molecules.MolecularPropertiesType;
import org.vamdc.xsams.species.molecules.MoleculeType;
import org.vamdc.xsams.species.molecules.ReferencedTextType;

public class Molecule extends MoleculeType{

	public Molecule(EnergyTables etable){
		MolecularChemicalSpeciesType mcst =  buildMolecularChemicalSpecies(etable.getToElements()/*getElementRel()*/);
		this.setMolecularChemicalSpecies(mcst);
		
		mcst.setComment(etable.getTitle());
		mcst.getMoleculeStructures().add(new BasecolMoleculeStructure(etable.getToElements()/*getElementRel()*/));
		
	}
	
	//Build molecule description
		private static MolecularChemicalSpeciesType buildMolecularChemicalSpecies(Elements element) {
			MolecularChemicalSpeciesType mol = new MolecularChemicalSpeciesType();
			mol.setChemicalName(new ReferencedTextType(element.getDesignation()));
			mol.setOrdinaryStructuralFormula(new ReferencedTextType(element.getLatex()));
			/*Inchi myinchi = element.getInchiRel();/*This could be null*//*there are no table Inchi anymore*/
			if (/*myinchi*/element.getInchi()!=null){
				mol.setInChI(/*myinchi*/element.getInchi());
				mol.setInChIKey(/*myinchi*/element.getInchiKey());
				mol.setVAMDCSpeciesID(/*myinchi*/element.getInchiKey());
			};
			mol.setStoichiometricFormula(element.getStoichiometricFormula());


			MolecularPropertiesType props = new MolecularPropertiesType();
			props.setMolecularWeight(new DataType(element.getMolecularMass(), "amu"));
			mol.setStableMolecularProperties(props);

			return mol;
		}
	
}
