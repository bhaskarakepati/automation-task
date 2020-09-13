package com.marsrover.steps;


import com.marsrover.Rover;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTaskSteps {

    private Rover rover;

    public RoverTaskSteps(Rover rover){
        this.rover = rover;
    }

    @Given("I have the rover initialized")
    public void iHaveTheRoverInitialized() {
        assertThat(rover).isNotNull();
    }

    @When("^I set position (.*) (.*) (.*)$")
    public void iSetPosition(String x, String y,String direction) {
        rover.setPosition(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(direction));
    }

    @When("^I move the rover with command (.*)$")
    public void iMoveTheRoverWithCommand(String command) {
        rover.process(command);
    }

    @And("^the Rover direction facing should be (.*)$")
    public void theRoverDirectionFacingShouldBe(String direction) {
        Map<String,String> positions = rover.printPosition();
        assertThat(positions.get("dir")).isEqualTo(direction);
    }

    @And("^the positioning should be initialised with x,y positions as (\\d+),(\\d+)$")
    public void thePostioningShouldBeInitialisedWithXYPostionAs(int x, int y) {
        Map<String,String> positions = rover.printPosition();
        assertThat(positions.get("x")).isEqualTo(String.valueOf(x));
        assertThat(positions.get("y")).isEqualTo(String.valueOf(y));
    }


    @Then("^the Rover destination should be (.*)$")
    public void theRoverDestinationShouldBe(String destination) {
        Map<String,String> destinationMap = rover.printPosition();
        assertThat(destinationMap.get("x")).isEqualTo(destination.split(",")[0]);
        assertThat(destinationMap.get("y")).isEqualTo(destination.split(",")[1]);
        assertThat(destinationMap.get("dir")).isEqualTo(destination.split(",")[2]);
    }

    @Given("^the x,y positions initialised as (.*),(.*) with facing (.*)$")
    public void theXYPositionsInitialisedAsWithFacingN(int x, int y,String direction) {
        rover.setPosition(x,y,facingValue(direction));
    }

    @When("^I move the rover facing towards (.*) with x,y position as (.*) (.*)$")
    public void iMoveTheRoverFacingTowardsDirectionWithXYPositionAs(String direction,Integer x,Integer y) {
        rover.setPosition(x,y,facingValue(direction));
        rover.process("M");
    }

    @When("^I move the rover facing with (.*)$")
    public void iMoveTheRoverFacingWith(String commands) {
        rover.process(commands);
    }

    private Integer facingValue(String direction){
        Map<String,Integer> directionMap = new HashMap<String, Integer>();
        directionMap.put("N",1);
        directionMap.put("E",2);
        directionMap.put("S",3);
        directionMap.put("W",4);

        return directionMap.get(direction);
    }
}
