package com.example.glue;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.domain.Driver;
import com.example.domain.Drivers;
import com.example.helper.CustomLogger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class DriverStepDef {
	private Drivers drivers = new Drivers();
	private List<String> data;
	
	@Given("I've entered the following drivers")
	public void i_ve_entered_the_following_drivers(io.cucumber.datatable.DataTable dataTable) {
		CustomLogger.showInfo("=== Given Step ===");
		this.data = dataTable.asList();
	}
	
	@When("I get the name calculation")
	public void i_get_the_name_calculation() {
		for(String name : this.data) {
			Driver driver = new Driver();
			driver.setName(name);
			driver.calculateNameAlgorithm();
			
			this.drivers.addDriver(driver);
		}
	}
	@Then("I should get the following results")
	public void i_should_get_the_following_results(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedVowels = dataTable.column(0);
		List<String> expectedConsonants = dataTable.column(1);
		List<Driver> currentDrivers = this.drivers.getDrivers();
		
		assertEquals(expectedVowels.get(1), Integer.toString(currentDrivers.get(0).getVowelAmount()));
		assertEquals(expectedConsonants.get(1), Integer.toString(currentDrivers.get(0).getConsonantAmount()));
		
		assertEquals(expectedVowels.get(2), Integer.toString(currentDrivers.get(1).getVowelAmount()));
		assertEquals(expectedConsonants.get(2), Integer.toString(currentDrivers.get(1).getConsonantAmount()));
		
		assertEquals(expectedVowels.get(3), Integer.toString(currentDrivers.get(2).getVowelAmount()));
		assertEquals(expectedConsonants.get(3), Integer.toString(currentDrivers.get(2).getConsonantAmount()));
	}
}
