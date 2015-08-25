package org.vamdc.basecol.xsams;

import org.vamdc.BasecolTest.dao.Elements;
import org.vamdc.BasecolTest.dao.MoleculeAtoms;
import org.vamdc.BasecolTest.dao.MoleculeBonds;
import org.vamdc.xsams.species.molecules.MoleculeStructureType;
import org.vamdc.xsams.util.IDs;
import org.xml_cml.schema.Atom;
import org.xml_cml.schema.AtomArray;
import org.xml_cml.schema.Bond;
import org.xml_cml.schema.BondArray;

public class BasecolMoleculeStructure extends MoleculeStructureType{
	
	public BasecolMoleculeStructure(Elements myElement){
		
		getAtomArraies().add(getAtoms(myElement));
		getBondArraies().add(getBonds(myElement));
		
	}
	
	public static String getAtomID(Integer idElement,Integer integer){
		return IDs.getID('R',""+idElement+"N"+integer);
	}
	
	private BondArray getBonds(Elements myElement) {
		BondArray bonds = new BondArray();
		for (MoleculeBonds bond:myElement.getMoleculebondss())/*getStructBondsRel())*/{
			bonds.getBonds().add(new CMLBond(bond,myElement.getIdElement().intValue()));
		}
		
		return bonds;
	}

	private AtomArray getAtoms(Elements myElement){
		AtomArray atoms = new AtomArray();
		for (MoleculeAtoms atom:myElement.getMoleculeatomss()/*getStructRel()*/){
			atoms.getAtoms().add(new CMLAtom(atom,myElement.getIdElement().intValue()));
		}
		return atoms;
	}
	
	private class CMLAtom extends Atom{
		
		public CMLAtom(MoleculeAtoms atom, Integer idElement){
			setCount(atom.getAtomCount().doubleValue());
			setElementType(atom.getNucleus().getSymbol()/*getNucleiRel()*/);
			setFormalCharge(atom.getAtomCharge().intValue());
			setHydrogenCount(atom.getHydrogenCount().intValue());
			setIsotopeNumber(atom.getNucleus().getIsotope());
			setId(getAtomID(idElement,atom.getAtomId()/*getAtomID()*/));
			
		}
		
	}
	
	private class CMLBond extends Bond{
		public CMLBond(MoleculeBonds bond,Integer idElement){
			getAtomRefs2s().add(getAtomID(idElement,bond.getAtom1().getAtomId()/*getAtom1Rel().getAtomID()*/));
			getAtomRefs2s().add(getAtomID(idElement,bond.getAtom2().getAtomId()/*getAtom2Rel().getAtomID()*/));
			setOrder(bond.getBondOrder());
		}
	}
	
}
