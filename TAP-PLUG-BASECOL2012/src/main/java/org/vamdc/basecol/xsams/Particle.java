package org.vamdc.basecol.xsams;

import java.util.Map;
import java.util.TreeMap;

import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.xsams.schema.ParticleNameType;
import org.vamdc.xsams.species.particles.ParticleType;
import org.vamdc.xsams.util.IDs;

public class Particle extends ParticleType{
	
	//Particles map:
	@SuppressWarnings("serial")
	public static Map<String,ParticleNameType> basecolParticles = new TreeMap<String,ParticleNameType>(){{
		put("electron",ParticleNameType.ELECTRON);
	}};
	
	
	public Particle(EnergyTables etable){
		
	this.setName(basecolParticles.get(etable.getToElements().getDesignation()));
	this.setComments(etable.getTitle());
	
	String id=IDs.getSpecieID(etable.getIdEnergyTable().intValue());
	this.setSpeciesID(id);
	
	}
}
