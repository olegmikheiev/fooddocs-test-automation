Feature: User can log in in order to get access to site functionality
  As a registered user
  I want to login into my account
  So that I can have access to restricted functionality

  Scenario: Guest user with invalid credentials cannot log in
    Given User is on a Home page
    And language is set to 'EN'
    When User performs login with email 'iam@web.net' and password 'blablabla'
    Then Login screen shows error message 'Invalid username and/or password'
