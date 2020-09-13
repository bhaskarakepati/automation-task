Feature: This is to test the Rover direction facing and position

  Scenario: This is to test the Rover direction facing and positioning initialisation

    Given I have the rover initialized
    Then the Rover direction facing should be N
    And the positioning should be initialised with x,y positions as 0,0


  Scenario Outline: This test is for moving the rover x and y position and location

    Given the x,y positions initialised as 0,0 with facing N
    When I move the rover facing towards <direction> with x,y position as <x> <y>
    Then the Rover destination should be <destination>
    Examples:
      | x  | y  | direction  |destination  |
      | 1  | 2  | N          | 1,3,N       |
      | 1  | 2  | S          | 1,1,S       |
      | 1  | 2  | E          | 2,2,E       |
      | 1  | 2  | W          | 0,2,W       |

  Scenario Outline: This is to test the move the rover as per the given scenario problem

    Given the x,y positions initialised as <x>,<y> with facing <direction>
    When I move the rover facing with <command>
    Then the Rover destination should be <destination>
    Examples:
      | x  | y  | direction  |command     | destination  |
      | 1  | 2  | N          |LMLMLMLMM   |  1,3,N       |
      | 3  | 3  | E          |MMRMMRMRRM  |  5,1,E       |