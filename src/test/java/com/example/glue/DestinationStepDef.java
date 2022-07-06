package com.example.glue;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.domain.Destination;
import com.example.domain.Destinations;
import com.example.helper.CustomLogger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DestinationStepDef {
	private Destinations destinations = new Destinations();
	
	@Given("I have the available destinations")
	public void i_have_the_available_destinations(io.cucumber.datatable.DataTable dataTable) {
		CustomLogger.showInfo("=== Given Step ===");
		for(String address : dataTable.asList()) {
			Destination destination = new Destination();
			destination.setAddress(address);
			destination.defineAdressCharAmountParity();
			destination.setAssignation(false);
			
			this.destinations.addDestination(destination);
		}
	}
	
	@When("I calculate the Address characters parity")
	public void i_calculate_the_address_characters_parity() {
		/**
		 * Step added for clarity purposes, it's just syntactic sugar.
		 * **/
		CustomLogger.showInfo("=== When Step ===");
		CustomLogger.showInfo("Address Parity already calculated.");
	}
	
	@Then("I should get the result below")
	public void i_should_get_the_result_below(io.cucumber.datatable.DataTable dataTable) {
		CustomLogger.showInfo("=== Then Step ===");
		List<String> expectedResults = dataTable.asList();
		
		int i = 0;
		for(String expectedResult : expectedResults) {
			boolean addressCharParity = this.destinations.getDestinations().get(i).hasEvenChars();
			CustomLogger.showInfo("Address Parity: " + addressCharParity);
			assertEquals(Boolean.parseBoolean(expectedResult), addressCharParity);
			i++;
		}
	}



}
