Feature: employee search scenarios

  Scenario: Search employee by employee id
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage
    When user clicks on PIM option
    And user enters employee id
    And user clicks on search button
    Then user is able to see employee details
