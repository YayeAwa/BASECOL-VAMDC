package org.vamdc.basecol.constants;

import java.util.Map;
import java.util.TreeMap;

import org.vamdc.xsams.util.QuantumNumber.QNType;


public enum BasecolQuantumNumber{
	//Name,index,mapping,mode index(where applicable)
	TOTAL_ANGULAR_MOMENTUM_J(1,QNType.J,0),
	ASYMMETRIC_KA(2,QNType.Ka,0),
	ASYMMETRIC_KC(3,QNType.Kc,0),
	//ASYMMETRIC_TAU(4,null,0),
	PARITY(7,QNType.Parity,0),
	HYPERFINECOUPLINGISUM(10,QNType.Fi,1),
	//EPSILON_SYMMETRY(11,null,0),
	VIBRATION_NU1(12,QNType.V,1),
	VIBRATION_NU2(13,QNType.V,2),
	VIBRATION_NU3(14,QNType.V,3),
	TOTAL_ANGULAR_MOMENTUM_F(17,QNType.F,0),
	VIBRATION_TORSION(18,QNType.V,12),
	SPINLABEL(19,QNType.spinLbl,0),
	UMBRELLA_SYMMETRY(22,QNType.vibInv,0),
	AXIS_MOMENTUM_PROJECTION_K(23,QNType.K,0),
	TOTAL_MOLECULAR_PROJECTION_L(24,QNType.L,0),
	TOTAL_SPIN_MOMENTUM_S(25,QNType.S,0),
	TOTAL_MOLECULAR_PROJECTION_OMEGA(26,QNType.Omega,0),
	KRONIG_PARITY_E_F(27,QNType.kParity,0),
	//ROTVIB_SYM(28,null,0)
	SIGN_AXIS_MOMENTUM_PROJECTION_K(29,QNType.K,0),
	TOTAL_ANGULAR_MOMENTUM_N(30,QNType.N,0)
	
	;
	
	private final Integer BasecolIndex;
	private final QNType mapping;
	private final Integer modeIdx;
	
	private final static Map<Integer,BasecolQuantumNumber> indexes = new TreeMap<Integer,BasecolQuantumNumber>(){
		private static final long serialVersionUID = 3843194955372858451L;
	{
		for (BasecolQuantumNumber qn:BasecolQuantumNumber.values()){
			this.put(qn.getIndex(), qn);
		}
	}};
	
	BasecolQuantumNumber(Integer basecolIndex,QNType mapping,int modeIndex){
		this.BasecolIndex = basecolIndex;
		this.mapping = mapping;
		this.modeIdx = modeIndex;
		
	}
	
	private Integer getIndex(){
		return BasecolIndex;
	}
	
	private Integer getModeIndex(){
		return modeIdx;
	}
	
	private QNType getMapping(){
		return mapping;
	}
	
	public static QNType GetCaseQNType(int qnumtype){
		BasecolQuantumNumber qn = indexes.get(qnumtype);
		if (qn ==null) return QNType.genQN;
		return qn.getMapping();
		
	};
	
	public static int GetModeIdx(int qnumtype){
		BasecolQuantumNumber qn = indexes.get(qnumtype);
		if (qn ==null) return 0;
		return qn.getModeIndex();
	}
}
