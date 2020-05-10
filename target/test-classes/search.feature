Feature: Google test

  Scenario: Search google
    Given am on the google home page
    When I enter word to be searched
    And I click the search button
    Then the search result should be return
