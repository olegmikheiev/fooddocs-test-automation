Feature: Home page form accessibility test
  As a guest user
  I want to have access to the basic functionality from the Home page
  So that I can use basic website functionality

  Scenario: Login page can be open from the Home page
    Given User is a 'guest' user
    And User is on a Home page
    When User navigates to the Login screen
    Then Login screen is open

  Scenario: Registration page can be open from the Home page
    Given User is a 'guest' user
    And User is on a Home page
    When User navigates to the Sign Up screen
    Then Registration screen is open
