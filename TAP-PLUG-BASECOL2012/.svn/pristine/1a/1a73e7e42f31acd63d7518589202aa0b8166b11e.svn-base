package org.vamdc.basecol.xsams;

import org.vamdc.xsams.schema.NuclearSpinIsomerType;
import org.vamdc.xsams.schema.SymmetryType;
import org.vamdc.xsams.species.molecules.MolecularStateType;

public class NuclearSpin extends NuclearSpinIsomerType{

	public NuclearSpin(String nss, MolecularStateType lowestRef) {
		this.setLowestEnergyStateRef(lowestRef);
		
		
		try{
			this.setName(nss.toLowerCase());
		}catch(IllegalArgumentException e){
			this.setLowestRoVibSym(new SymmetryType());
			this.getLowestRoVibSym().setValue(nss);
		}
	}

}
