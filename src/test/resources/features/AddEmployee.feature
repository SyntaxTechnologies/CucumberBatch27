Feature: Add employee scenarios





  @add
  Scenario: Adding one employee
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage
    When user clicks on PIM option
    When user clicks on add employee option
    And user enters firstname and middlename and lastname
    And user clicks on save button
    Then user is able to add employee sucessfully

  @param
  Scenario: Adding one employee using parameters
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage
    When user clicks on PIM option
    When user clicks on add employee option
    And user enters "adam" and "ms" and "belhoul" values
    And user clicks on save button
    Then user is able to add employee sucessfully

  @examples
  Scenario Outline: Adding multiple employees using examples table to get data driven testing done
    Given user is able to launch the application
    When user enters username and password
    And user clicks on login button
    Then user is navigated to homepage
    When user clicks on PIM option
    When user clicks on add employee option
    And user enters "<firstName>" and "<middleName>" and "<lastName>" keys
    And user clicks on save button
    Then user is able to add employee sucessfully
    Examples:
      | firstName       | middleName | lastName |
      | adam            |ms          |belhoul   |
      | secondadam      |ms          |belhoul   |
      | thirdadam       |ms          |belhoul   |




