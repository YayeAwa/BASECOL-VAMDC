package org.vamdc.BasecolTest.misc;

import java.util.ArrayList;
import java.util.List;



public class RatesTemperatureMap {
	private List<Double> temperatures;
	private List<Double> rates;
	private long levelGroupID;
	
	public RatesTemperatureMap(long levelGroupID){
		temperatures=new ArrayList<Double>();
		rates=new ArrayList<Double>();
		this.levelGroupID=levelGroupID;
	}
	
	public void addPoint(Double temperature, Double rate){
		temperatures.add(temperature);
		rates.add(rate);
	}
	
	public List<Double> getTemperatures(){
		return temperatures;
	}
	
	public List<Double> getRates(){
		return rates;
	}
	
	@Deprecated
	public String getID(){
		return "";
	}

	public long getLevelGroupID() {
		return levelGroupID;
	}
	
}
