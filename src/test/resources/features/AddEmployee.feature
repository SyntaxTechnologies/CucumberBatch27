Feature: Add employee scenarios

 Background:
   #Given user is able to launch the application
   When user enters username and password
   And user clicks on login button
   Then user is navigated to homepage
   When user clicks on PIM option
   When user clicks on add employee option


  @add
  Scenario: Adding one employee
    And user enters firstname and middlename and lastname
    And user clicks on save button
    Then user is able to add employee sucessfully

  @param
  Scenario: Adding one employee using parameters
    And user enters "adam" and "ms" and "belhoul" values
    And user clicks on save button
    Then user is able to add employee sucessfully

  @examples
  Scenario Outline: Adding multiple employees using examples table to get data driven testing done
    And user enters "<firstName>" and "<middleName>" and "<lastName>" keys
    And user clicks on save button
    Then user is able to add employee sucessfully
    Examples:
      | firstName       | middleName | lastName |
      | adam            |ms          |belhoul   |
      | secondadam      |ms          |belhoul   |
      | thirdadam       |ms          |belhoul   |

  @datatable
  Scenario:  Adding mulitple employees using data table
    When user adds employees from datatable and verify them
    |firstName        |middleName  |lastname  |
    | adam            |ms          |belhoul   |
    | secondadam      |ms          |belhoul   |
    | thirdadam       |ms          |belhoul   |


    @excel
    Scenario: Adding employees from excel file
      When user adds employees from excel file and validate them






