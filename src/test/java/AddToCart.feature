Feature: User Cart Functionality

  Scenario: User adds items to the cart from the Bakery
    Given the user is on the home page without being signed in
    When the user selects the account link text and signs in
    And enters the email and continues for login
    And sets the password and logs in
    And hovers over the Bakery section
    And chooses and adds the first item to the cart
    And chooses and adds the second item to the cart
    And goes to the cart
    Then the cart should contain the following items and subtotal
      | Item                                  | Description                                            | Subtotal |
      | Wooden Tool For Pressing Dough         | (Verify the details for the first item here)           | 267.89   |
      | 915 Generation Copper Sheet Roll, ... | (Verify the details for the second item here)          |          |
