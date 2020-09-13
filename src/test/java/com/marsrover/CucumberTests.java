package com.marsrover;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html","json:build/cucumber/cucumber-json-report.json"},
        features ="src/test/resources/features",
        glue = {"com.marsrover.steps"}
)
public class CucumberTests {

}

