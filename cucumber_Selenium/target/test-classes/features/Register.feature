Feature: User Registration

  Scenario: Registration using Excel data
    Given user is on the registration page
    When user enters registration details
    And clicks on Register button
    Then registration should be successful