Feature: Register New User

  Scenario Outline: Register User
    Given The user is already registration page
    When The user inserts <Email> and <Phone>
    And The user clicks to accept terms and conditions
    And The user clicks Next
    Then A modal of email sent must be displayed
    And A text box to insert the code sent to phone must be displayed

    Examples:
      |Email|Phone|
      |antonio@dominio.dominio|914567890|

