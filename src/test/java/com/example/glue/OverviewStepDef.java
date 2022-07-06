package com.example.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.Destination;
import com.example.domain.Driver;
import com.example.domain.SuitabilityScore;

public class OverviewStepDef {
	private  List<String> domainEntityNames;
	
	@Given("I have the following domain entities")
	public void i_have_the_following_domain_entities(io.cucumber.datatable.DataTable dataTable) {
		domainEntityNames = dataTable.asList();
	}
	
	@When("I want to consume their functionality")
	public void i_want_to_consume_their_functionality() {
		/**
		 * Step added for clarity purposes, it's just syntactic sugar.
		 * **/
	}
	
	@Then("I should get the following Driver features")
	public void i_should_get_the_following_driver_features(io.cucumber.datatable.DataTable dataTable) {
	    List<String> expectedMethodNames = dataTable.asList();
	    
	    assertTrue(Driver.class.getName().endsWith(this.domainEntityNames.get(0)));
	    
	    Class<Driver> classobj = Driver.class;
        Method[] methods = classobj.getMethods();
        
        this.validateEntityFeatures(methods, expectedMethodNames);
	}
	
	@Then("I should get the following Destination features")
	public void i_should_get_the_following_destination_features(io.cucumber.datatable.DataTable dataTable) {
	    List<String> expectedMethodNames = dataTable.asList();
	    
	    assertTrue(Destination.class.getName().endsWith(this.domainEntityNames.get(1)));
	    
	    Class<Destination> classobj = Destination.class;
        Method[] methods = classobj.getMethods();
        
        this.validateEntityFeatures(methods, expectedMethodNames);
	}

	@Then("I should get the following Suitability Score features")
	public void i_should_get_the_following_suitability_score_features(io.cucumber.datatable.DataTable dataTable) {
	    List<String> expectedMethodNames = dataTable.asList();
	    
	    assertTrue(SuitabilityScore.class.getName().endsWith(this.domainEntityNames.get(2)));
	    
	    Class<SuitabilityScore> classObj = SuitabilityScore.class;
        Method[] methods = classObj.getMethods();
        
        this.validateEntityFeatures(methods, expectedMethodNames);
	}

	private void validateEntityFeatures(Method[] runtimeMethodNames, List<String> expectedMethodNames) {
		List<String> currentMethodNames = new ArrayList<String>();
		
        for(Method method : runtimeMethodNames) {
        	currentMethodNames.add(method.getName());
        }
        
        for(String expectedMethodName : expectedMethodNames) {
        	 assertTrue(currentMethodNames.contains(expectedMethodName));
        }
	}
}
