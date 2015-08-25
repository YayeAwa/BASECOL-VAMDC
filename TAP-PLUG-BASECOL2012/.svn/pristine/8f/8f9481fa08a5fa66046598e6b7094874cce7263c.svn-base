package org.vamdc.basecol.constants;

/*
 * units as they are in Basecol
 * Could be replaced or extended some day with XSAMSUnit column in basecol.Units 
 */

public class BasecolUnits {
	public static final int Kelvin = 2;
	public static final int m=4;
	public static final int deg=10;
	public static final int none=1;
	public static final int invcm=16;
	public static final int amu=19;
	
	public static String getXSAMSUnit(int BASECOLUnit){
		//Return only implemented cases:
		switch (BASECOLUnit){
			case BasecolUnits.Kelvin: return "K";
			case BasecolUnits.m: return "m";
			case BasecolUnits.deg: return "deg";
			case BasecolUnits.none: return "unitless";
			case BasecolUnits.invcm: return "1/cm";
			case BasecolUnits.amu: return "amu";
			default: return "unitless";
		}
	}
	
	/*
+--------+-------------+-----------+
| idUnit | designation | latex     |
+--------+-------------+-----------+
|      2 | Kelvin      | Kelvin    |
|      4 | m           | m         |
|     10 | °           | °         |
|      1 |             |           |
|     16 | cm^-1       | $cm^{-1}$ |
|     19 | a.m.u.      | a.m.u.    |
+--------+-------------+-----------+|
	 */
}
