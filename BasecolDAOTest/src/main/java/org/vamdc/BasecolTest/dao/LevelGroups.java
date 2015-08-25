package org.vamdc.BasecolTest.dao;

import org.vamdc.basecolTest.dao.auto._LevelGroups;

public class LevelGroups extends _LevelGroups {

	public String getID(){
		return "t"+this.getToETLInitTarget().getLevel()+
				"T"+this.getToETLFinalTarget().getLevel()+
				"c"+this.getToETLInitCollider().getLevel()+
				"C"+this.getToETLFinalCollider().getLevel();
	}
}
