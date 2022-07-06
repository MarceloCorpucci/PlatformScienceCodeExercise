package com.example.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.helper.CustomLogger;

public class SuitabilityScore {
	private List<Driver> drivers;
	private List<Destination> destinations;
	private float score;
	private float maxScore = 0;
	private Map<Float, Destination> scorePerDestination = new HashMap<Float, Destination>();
	private Map<Driver, Float> maxScorePerDriver = new HashMap<Driver, Float>();
	private Map<Driver, Destination> driverPerDestination = new HashMap<Driver, Destination>();
	
	public SuitabilityScore(Drivers drivers, Destinations destinations) {
		this.drivers = drivers.getDrivers();
		this.destinations = destinations.getDestinations();
	}
	
	public void calculate() {
		CustomLogger.showInfo("Calculating Suitability Score: ");

		for(Driver driver : drivers) {
			CustomLogger.showInfo("Driver: " + driver.getName());
			
			for(Destination destination : destinations) {
				
				if(!destination.isAssigned()) {
					CustomLogger.showInfo("Destination to be reviewed: "+ destination.getAddress());
					CustomLogger.showInfo("Destination is not assigned yet.");
					
					this.runSuitabilityScore(destination, driver);
					
					if(score > maxScore) {
						CustomLogger.showInfo("Current score is Max.");
						
						this.updateScorePerDriver(driver);
						
						this.evaluateDriverPreviousAssignation(driver);
						
						CustomLogger.showInfo("Address " + destinations.get(destinations.indexOf(destination)).getAddress() + " was assigned.");
						
						driverPerDestination.put(driver, destination);
						destinations.get(destinations.indexOf(destination)).setAssignation(true);
					}
				}
			}
			score = 0;
			maxScore = 0;
			CustomLogger.showInfo("--- ---");
		}
	}
	
	public Map<Driver, Float> getMaxScorePerDriver(boolean loggingEnabled) {
		if(loggingEnabled) {
			CustomLogger.showInfo("Max score per driver");
			maxScorePerDriver.forEach((k,v) -> CustomLogger.showInfo("Driver = " + k.getName() + ", Score = " + v));
		}
	    
		return maxScorePerDriver;
	}
	
	public Map<Driver, Destination> getDriverPerDestination(boolean loggingEnabled) {
		if(loggingEnabled) {
			CustomLogger.showInfo("Driver per Destination Address");
			driverPerDestination.forEach((k,v) -> CustomLogger.showInfo("Driver = " + k.getName() + ", Address = " + v.getAddress()));
		}
		
		return driverPerDestination;
	}
	
	private void runSuitabilityScore(Destination destination, Driver driver) {
		if(destination.hasEvenChars()) {
			score = driver.getVowelAmount() * 1.5f;
			CustomLogger.showInfo("Destination Address has even amount of chars. Score: " + score);
		} else {
			score = driver.getConsonantAmount();
			CustomLogger.showInfo("Destination address has odd amount of chars. Score: " + score);
		}
		scorePerDestination.put(score, destination);
	}
	
	private void updateScorePerDriver(Driver driver) {
		maxScore = score;
		
		maxScorePerDriver.remove(driver);
		maxScorePerDriver.put(driver, maxScore);
	}
	
	private void evaluateDriverPreviousAssignation(Driver driver) {
		if(driverPerDestination.containsKey(driver)) {
			Destination previousDest = driverPerDestination.get(driver);
			CustomLogger.showInfo("Destination " + previousDest.getAddress() + " was assigned previously, but now it is unassigned again.");
			destinations.get(destinations.indexOf(previousDest)).setAssignation(false);
			driverPerDestination.remove(driver);
		}
	}
}
