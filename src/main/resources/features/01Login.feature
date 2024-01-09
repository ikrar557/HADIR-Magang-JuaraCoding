Feature: User Login

  Scenario: User Login Valid
    Given User enter admin login page
    When User enter email
    And User enter password
    And User click login button
    Then User login successful