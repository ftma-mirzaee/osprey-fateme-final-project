@Regression @LoginFunctionality
Feature: profile page functionality



  Scenario: validation of profile page
    Given click on login button and login with correct credentials
      | Username | supervisor     |
      | Password | tek_supervisor |
    And click on sign in button
    When click on profile button
    Then validate profile page information is correct "STATUS:Active, USER TYPE:CSR, FULL NAME:Supervisor, USERNAME:supervisor, AUTHORITIES:admin"
    And validate log out button that navigates you to home page