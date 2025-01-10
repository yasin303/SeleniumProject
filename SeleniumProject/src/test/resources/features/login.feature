@login
Feature: Login

  @valid-login
  Scenario: Login with valid username and password
    Given user is on login page
    When user input username text box with "standard_user"
    And user input password text box with "secret_sauce"
    And user click login button
    Then user will redirect to hompage

  @invalid-login
  Scenario: Login with invalid username and password
    Given user is on login page
    When user input username text box with "standarduser"
    And user input password text box with "secretsauce"
    And user click login button
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service"