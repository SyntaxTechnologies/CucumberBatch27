Feature: employee search scenarios

  @hafida @regression @sprint3
  Scenario: Search employee by employee id
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage
    When user clicks on PIM option
    And user enters employee id
    And user clicks on search button
    Then user is able to see employee details

  @yana @sprint2 @smoke @regression
  Scenario: Search employee by name
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage
    When user clicks on PIM option
    And user enters employee name
    And user clicks on search button
    Then user is able to see employee details

