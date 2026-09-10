Feature: API

  @api
  Scenario: creating an employee
    Given a request is prepared to create an employee using POST call
    When a POST call has been made
    Then employee should be created and status code should be 201
