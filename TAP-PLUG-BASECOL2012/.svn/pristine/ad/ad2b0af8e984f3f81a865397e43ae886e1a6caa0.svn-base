package org.vamdc.basecol.xsams;

import org.vamdc.xsams.common.ValueType;
import org.vamdc.xsams.species.molecules.MolecularStateCharacterisationType;
import org.vamdc.xsams.species.molecules.MolecularStateType;
import org.vamdc.xsams.species.molecules.StateEnergyType;
import org.vamdc.xsams.util.StateCore;

public class ZeroPointState extends MolecularStateType{
	
	public ZeroPointState(StateCore state, boolean addQuantumNumbers){

		this.setDescription(state.getEnergyOrigin());
		this.setAuxillary(true);

		MolecularStateCharacterisationType msChar = new MolecularStateCharacterisationType();
		this.setMolecularStateCharacterisation(msChar);

		StateEnergyType stateEnergy = new StateEnergyType();
		msChar.setStateEnergy(stateEnergy);
		stateEnergy.setValue(new ValueType(0.,state.getEnergyUnits()));

		stateEnergy.setEnergyOrigin(this);

		//All quantum numbers are now here:
		//if (addQuantumNumbers)
		//	this.getCases().add(CaseBuilder.buidCase(state));

	}

}
