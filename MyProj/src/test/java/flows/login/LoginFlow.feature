Feature: Login New User

  Scenario Outline: Login User
    Given The user is already Login page
    When The user inserts <Email> and <Password>
    And The user clicks to submit
    Then a new page must be open displaying a message user not authorized

    Examples:
      |Email|Password|
      |1200188@isep.ipp.pt|#MyPass1|