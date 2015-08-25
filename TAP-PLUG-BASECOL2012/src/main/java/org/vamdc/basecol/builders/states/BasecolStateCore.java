package org.vamdc.basecol.builders.states;

import java.util.List;

import org.vamdc.basecol.constants.BasecolQuantumNumber;
import org.vamdc.basecol.constants.BasecolUnits;
import org.vamdc.BasecolTest.dao.CaseByCase;
import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.BasecolTest.dao.EnergyTablesLevels;
import org.vamdc.BasecolTest.dao.EnergyTablesLevelsQuantumNumbers;
import org.vamdc.BasecolTest.dao.HyperfineQNums;
import org.vamdc.basecol.xsams.BasecolMoleculeStructure;
import org.vamdc.xsams.util.IDs;
import org.vamdc.xsams.util.QuantumNumber;
import org.vamdc.xsams.util.QuantumNumber.QNType;
import org.vamdc.xsams.util.StateCore;

public class BasecolStateCore extends StateCore {
	public BasecolStateCore(EnergyTables myetable,
			EnergyTablesLevels levels) {

		this.setID(IDs.getStateID(myetable.getIdEnergyTable().intValue(),levels.getLevel().intValue()));///*getIdEnergyTable()*/
		this.setEnergy(levels.getEnergy());
		this.setEnergyUnits(BasecolUnits.getXSAMSUnit(levels.getToEnergyTables().getToUnits().getIdUnit().intValue()));// getLvlEtableRel().getEnergyUnit()
		this.setEnergyOrigin(myetable.getEnergyOrigin());

		CaseByCase mycase=null;

		List<CaseByCase> cases= myetable.getCasebycases();//myetable.getToElements().getCasebycases();
		
		if (cases==null||cases.size()!=1){
			cases = myetable.getToElements().getCasebycases();
			for(CaseByCase thiscase : cases){
				if (thiscase!=null && (thiscase.getIdEnergyTable()==null||thiscase.getIdEnergyTable()==0)){
					mycase=thiscase;
					break;
				}
			}
		}else{
			mycase=cases.get(0);
		}
		
			
		if (mycase!=null){
			this.setCaseID(mycase.getIdCase());
		}else{
			this.setCaseID(0);
		}

		this.setNuclearspinsymmetry(myetable.getToSymmetries()/*getSymelementRel().getSymmetryRel()*/.getDesignation());

		this.setDescription(myetable.getTitle());

		this.setElecState(myetable.getElectronicComponentDescription());

		//add state quantum numbers:
		List<HyperfineQNums> hfqns= myetable.getHyperfineQnumss();
		for (EnergyTablesLevelsQuantumNumbers myqn:levels.getEnergytablesLevelsQuantumnumberss()/*getQNumbersRel()*/){
			QNType type = BasecolQuantumNumber.GetCaseQNType(myqn.getIdQuantumNumber().intValue());
			if (type!=null){
				QuantumNumber qNum = new QuantumNumber();
				qNum.setType(type);
				qNum.setModeIndex(BasecolQuantumNumber.GetModeIdx(myqn.getIdQuantumNumber().intValue()));
				//If we have a referenced nucleus
				if (hfqns!=null && hfqns.size()>0)
					for (HyperfineQNums hfqn:hfqns){
						if (hfqn.getIdQNumber()==myqn.getIdQuantumNumber())
							qNum.setRefSpin(
									BasecolMoleculeStructure.getAtomID(myetable.getToElements().getIdElement().intValue(), 
											hfqn.getIdMolNucleus()));
					}
				qNum.setValue(myqn.getValue());
				this.AddQNum(qNum);
			}
		}

	}
}
