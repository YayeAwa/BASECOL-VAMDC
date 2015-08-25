package org.vamdc.basecol.xsams;

import org.vamdc.xsams.common.DataType;
import org.vamdc.xsams.schema.OrbitalAngularMomentumType;
import org.vamdc.xsams.species.atoms.AtomicComponentType;
import org.vamdc.xsams.species.atoms.AtomicCompositionType;
import org.vamdc.xsams.species.atoms.AtomicNumericalDataType;
import org.vamdc.xsams.species.atoms.AtomicQuantumNumbersType;
import org.vamdc.xsams.species.atoms.AtomicStateType;
import org.vamdc.xsams.species.atoms.LSCouplingType;
import org.vamdc.xsams.species.atoms.TermType;
import org.vamdc.xsams.util.QuantumNumber.QNType;
import org.vamdc.xsams.util.StateCore;

public class AtomState extends AtomicStateType {

	public AtomState(StateCore statedata){
		this.setStateID(statedata.getId());
		
		AtomicNumericalDataType andt = new AtomicNumericalDataType();
		this.setAtomicNumericalData(andt);
		
		andt.setStateEnergy(new DataType(statedata.getEnergy(),statedata.getEnergyUnits()));
		
		AtomicCompositionType acst = new AtomicCompositionType();
		this.setAtomicComposition(acst);

		if (statedata.checkQNum(QNType.J)){
			AtomicQuantumNumbersType aq = new AtomicQuantumNumbersType();
			aq.setTotalAngularMomentum(statedata.getQNumByType(QNType.J).getValue());
			this.setAtomicQuantumNumbers(aq);
		}
		
		//LS coupling
		if (statedata.checkQNum(QNType.S)&&statedata.checkQNum(QNType.L)){
			AtomicComponentType act = new AtomicComponentType();
			TermType tt = new TermType();
			LSCouplingType ls = new LSCouplingType();
			OrbitalAngularMomentumType oat = new OrbitalAngularMomentumType();
			oat.setSymbol("L");
			oat.setValue(statedata.getQNumByType(QNType.L).getValue().intValue());
			ls.setL(oat);
			ls.setS(statedata.getQNumByType(QNType.S).getValue());
			tt.setLS(ls);
			act.setTerm(tt);
			acst.getComponents().add(act);
		}
		
	}
	
}
