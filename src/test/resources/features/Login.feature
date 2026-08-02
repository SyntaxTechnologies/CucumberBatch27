Feature: Login related scenarios

  Scenario: valid admin login
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage


  Scenario: invalid admin login
    Given user is able to launch the application
    When user enters invalid username and password
    And user clicks on login button
    Then user is able to see error message





