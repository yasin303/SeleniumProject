Feature: Login

  Scenario: Login with valid username and password
    Given user is on login page
    When user input username text box with "standard_user"
    And user input password text box with "secret_sauce"
    And user click login button
    Then user will redirect to hompage

  Scenario: Login with valid username and password
    Given user is on login page
    When user input username text box with "standarduser"
    And user input password text box with "secretsauce"
    And user click login button
    Then user will redirect to hompage