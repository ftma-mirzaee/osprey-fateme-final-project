@Smoke @LoginFunctionality
Feature: Login page functionality

  Background: first steps
    Given click on login button

  @CorrectCredentials
  Scenario: Login to tek insurance app
    When enter valid credentials
      | Username | supervisor     |
      | Password | tek_supervisor |
    Then click on sign in button and validate user is in customer service portal

  @WrongCredentials
  Scenario Outline: Validate Sign in with Invalid Credentials
    When user enter invalid "<Username>" and valid "<Password>"
    Then click on sign in button and validate user can not login
    Examples:
      | Username   | Password        |
      | Student    | tek_supervisor  |
      | supervisor | tek_supervisor2 |


