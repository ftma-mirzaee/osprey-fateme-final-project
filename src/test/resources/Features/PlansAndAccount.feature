@Regression
Feature: plans page functionalities


  Background: navigating to customer service portal
    Given navigate to plan page with correct credentials
      | Username | supervisor     |
      | Password | tek_supervisor |


  @PlanPageFunctionality
  Scenario: validating plan page
    Given validate 4 row of data is present
    Then validate create date is today date in Est time zone
    And Date Expire is a day after today in Est time zone


  @AccountPageFunctionality
  Scenario: Validating five row is default in Account page
    Given verify that 5 row page is default



  @AccountPageFunctionality
  Scenario Outline: validate that number of records match with show per page drop down
    When rows are "<Show>" number of records should be same as show
    Examples:
      | Show    |
      | Show 10 |
      | Show 25 |
      | Show 50 |
