package com.example.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		glue={"com.example.glue"},
		tags="@wip"
		)
public class CucumberWipRunner {

}
