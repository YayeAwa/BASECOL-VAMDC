package org.vamdc.basecol.builders;

//Common parameters for single collision
//Energy levels for single collision
//Comparison function for stored levels

public class CollisionalCommon {
	public int idCollider;
	public int idTarget;
	public String comment;
	public int idref;
	public int ETableTarget;
	public int ETableCollider;
	public int SETarget;
	public int SECollider;
	public int iTLevel;
	public int fTLevel;
	public int iCLevel;
	public int fCLevel;
	public org.vamdc.xsams.common.TabulatedDataType myRateCoeffs; 
	private boolean start = true;
	//Start us
	public void setthis(int iTL, int fTL, int iCL, int fCL){
		this.iTLevel = iTL;
		this.iCLevel = iCL;
		this.fTLevel = fTL;
		this.fCLevel = fCL;
	}
	//Returns true if some level has changed and it's not the first call to function
	public boolean checknext(int iTL, int fTL, int iCL, int fCL){
		if (start){
			this.setthis(iTL, fTL, iCL, fCL);
			start = false;
			return false;
		}
		if (	this.iTLevel != iTL ||
				this.iCLevel != iCL ||
				this.fTLevel != fTL ||
				this.fCLevel != fCL )
		{
			return true;
		}
		return false;
	}
	
}
