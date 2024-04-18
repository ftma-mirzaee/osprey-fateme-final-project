@Smoke
Feature: Major functionalities of tek insurance app home page


  Scenario: navigating to home page
    When navigate to the home page and validate that the title "Tek Insurance UI"
    Then validate create Primary Account Button exist

  @createAccount
  Scenario: creating account
    Given click on Create Primary Account button
    When navigate to Create Account form page and validate form title "Create Primary Account Holder"
    Then user fill up the form
      | Email Address  | students@tekschool.us |
      | First Name     | windy                 |
      | Gender         | Female                |
      | Title/Prefix   | Mrs                   |
      | Last Name      | Ruiz                  |
      | Marital Status | Married               |
      | Date Of Birth  | 04/02/1989            |
    And click on create account button
    Then validate user navigate to signup page and email address shows as expected

  @CreateAccountWithExistedEmail
  Scenario: Creating account with existing email
    Given Navigate to insurance app and click on create account button
    Given create account with existed email
      | Email Address  | students@tekschool.us |
      | First Name     | david                 |
      | Gender         | male                  |
      | Title/Prefix   | Mr                    |
      | Last Name      | Ruiz                  |
      | Marital Status | single                |
      | Date Of Birth  | 04/02/1998             |
    Then Click create account validate error message as expected
