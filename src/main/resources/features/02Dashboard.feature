Feature: User Dashboard
  #1
  Scenario: User move to division menu
    Given User click management sidebar

    When User click division sidebar
    Then User success move to division menu
#    When User click unit sidebar
#    Then User success move to unit menu