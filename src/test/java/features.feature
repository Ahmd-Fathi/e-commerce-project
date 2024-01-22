Feature: User Registration

  Scenario: User registration with personal details
    Given the user is on the home page
    When the user clicks on the account link text and signs in
    And enters the email and continues for registration
    And sets the password and logs in for registration
    And provides personal details including First Name, Last Name, and Phone Number
    And sets gender and birth information
    Then the user should be successfully registered

