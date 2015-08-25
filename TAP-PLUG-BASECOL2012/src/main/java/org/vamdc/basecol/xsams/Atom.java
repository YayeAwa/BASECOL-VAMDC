package org.vamdc.basecol.xsams;

import org.vamdc.BasecolTest.dao.Elements;
import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.xsams.common.ChemicalElementType;
import org.vamdc.xsams.common.DataType;
import org.vamdc.xsams.species.atoms.AtomType;
import org.vamdc.xsams.species.atoms.AtomicIonType;
import org.vamdc.xsams.species.atoms.IsotopeParametersType;
import org.vamdc.xsams.species.atoms.IsotopeType;
import org.vamdc.xsams.util.IDs;
import org.vamdc.xsams.util.XsamsUnits;

public class Atom extends AtomType{

	public Atom(EnergyTables myetable){
		Elements myelement = myetable.getToElements();//getElementRel();
		
		this.setChemicalElement(new ChemicalElementType(myelement.getStoichiometricFormula()));
		
		IsotopeType isot = new IsotopeType();
		this.getIsotopes().add(isot);
		
		AtomicIonType ion = new AtomicIonType();
		isot.getIons().add(ion);
		
		ion.setIonCharge(myelement.getCharge().intValue());
		
		ion.setInChIKey(myelement.getInchiKey());/*getInchiRel().getInchiKey()*/
		ion.setSpeciesID(IDs.getSpecieID(myelement.getIdElement().intValue()));
		
		IsotopeParametersType ipt = new IsotopeParametersType();
		isot.setIsotopeParameters(ipt);
		ipt.setMassNumber((int)Math.round(myelement.getMolecularMass()));
		ipt.setMass(new DataType(myelement.getMolecularMass(), XsamsUnits.AMU));
		
	}
	
}
