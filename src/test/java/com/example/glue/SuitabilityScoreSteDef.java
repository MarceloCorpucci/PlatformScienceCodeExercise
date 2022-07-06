package com.example.glue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Destination;
import com.example.domain.Destinations;
import com.example.domain.Driver;
import com.example.domain.Drivers;
import com.example.domain.SuitabilityScore;
import com.example.helper.CustomLogger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuitabilityScoreSteDef {
	private Drivers drivers = new Drivers();
	private Destinations destinations = new Destinations();
	private List<String> expectedDrivers;
	private List<String> expectedScores;
	private List<String> expectedAddresses;
	private SuitabilityScore suitabilityScore;
	
	@Given("I already count with a list of Drivers")
	public void i_already_count_with_a_list_of_drivers(io.cucumber.datatable.DataTable dataTable) {
		CustomLogger.showInfo("=== Background Step ===");
		
		for(String name : dataTable.asList()) {
			Driver driver = new Driver();
			driver.setName(name);
			driver.calculateNameAlgorithm();
			
			this.drivers.addDriver(driver);
		}
	}
	
@Given("I have the following destination list")
	public void i_have_the_following_destination_list(io.cucumber.datatable.DataTable dataTable) {
		CustomLogger.showInfo("=== Given Step ===");
		for(String address : dataTable.asList()) {
			Destination destination = new Destination();
			destination.setAddress(address);
			destination.defineAdressCharAmountParity();
			destination.setAssignation(false);
			
			this.destinations.addDestination(destination);
		}
	}

	@When("I calculate the suitability score")
	public void i_calculate_the_suitability_score() {
		CustomLogger.showInfo("=== When Step ===");
		this.suitabilityScore = new SuitabilityScore(this.drivers, this.destinations);
	    this.suitabilityScore.calculate();
	}
	
	@Then("I should get the results bellow")
	public void i_should_get_the_results_bellow(io.cucumber.datatable.DataTable dataTable) {
		CustomLogger.showInfo("=== Then Step ===");
		this.expectedDrivers = dataTable.column(0);
		this.expectedScores = dataTable.column(1);
		this.expectedAddresses = dataTable.column(2);
		
		List<String> currentDrivers = new ArrayList<>();
		this.drivers.getDrivers().stream().forEach((Driver driver) -> {
            currentDrivers.add(driver.getName());
        });
		assertTrue(this.expectedDrivers.containsAll(currentDrivers));
		
	    assertEquals(this.expectedScores.get(1), this.suitabilityScore.getMaxScorePerDriver(true).get(this.drivers.getDrivers().get(0)).toString());
	    assertEquals(this.expectedScores.get(2), this.suitabilityScore.getMaxScorePerDriver(false).get(this.drivers.getDrivers().get(1)).toString());
	    assertEquals(this.expectedScores.get(3), this.suitabilityScore.getMaxScorePerDriver(false).get(this.drivers.getDrivers().get(2)).toString());
	    
	    assertEquals(this.expectedAddresses.get(1), this.suitabilityScore.getDriverPerDestination(true).get(this.drivers.getDrivers().get(0)).getAddress());
	    assertEquals(this.expectedAddresses.get(2), this.suitabilityScore.getDriverPerDestination(false).get(this.drivers.getDrivers().get(1)).getAddress());
	    assertEquals(this.expectedAddresses.get(3), this.suitabilityScore.getDriverPerDestination(false).get(this.drivers.getDrivers().get(2)).getAddress());
	}
}
