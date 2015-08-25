package org.vamdc.basecol.xsams;

import org.vamdc.xsams.cases.CaseBuilder;
import org.vamdc.xsams.common.ValueType;
import org.vamdc.xsams.species.molecules.MolecularStateCharacterisationType;
import org.vamdc.xsams.species.molecules.MolecularStateType;
import org.vamdc.xsams.species.molecules.StateEnergyType;
import org.vamdc.xsams.util.StateCore;

public class MolecularState extends MolecularStateType{

	public MolecularState(StateCore state, MolecularStateType zpeRef,MolecularStateType lowestRef, boolean addQuantumNumbers){

		this.setDescription(state.getDescription());

		MolecularStateCharacterisationType msChar = new MolecularStateCharacterisationType();
		this.setMolecularStateCharacterisation(msChar);

		StateEnergyType stateEnergy = new StateEnergyType();
		msChar.setStateEnergy(stateEnergy);
		stateEnergy.setValue(new ValueType(state.getEnergy(),state.getEnergyUnits()));

		if (zpeRef==null)
			stateEnergy.setEnergyOrigin(this);
		else
			stateEnergy.setEnergyOrigin(zpeRef);

		String nss = state.getNuclearspinsymmetry();
		if (nss != null && !nss.equals("none")){
			if (lowestRef==null)
				lowestRef=this;
			msChar.setNuclearSpinIsomer(
					new NuclearSpin(nss,lowestRef));
		};

		//All quantum numbers are now here:
		if (addQuantumNumbers)
			this.getCases().add(CaseBuilder.buidCase(state));

		//Set state ID:
		this.setStateID(state.getId());

	}

}
