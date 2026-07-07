Feature: Searching Course Web Development

  Background:
    Given User launches Coursera website


  Scenario: Launch Coursera Website and Verify Search Box
    When Verify search box is visible and enabled

  Scenario: Search for "Web Development" and verify Search
    And User searches for "Web Development"


  Scenario: Apply Beginner Filter
    When User searches for "Web Development"
    And User applies Beginner level filter


  Scenario: Apply English Language Filter
    When User searches for "Web Development"
    And User applies Beginner level filter
    And User applies English language filter
    Then Verify at least two courses are displayed


  Scenario: Capture First Course Details
    When User searches for "Web Development"
    And User applies Beginner level filter
    And User applies English language filter
    Then Verify at least two courses are displayed
    And Capture first course details


  Scenario: Capture Second Course Details
    When User searches for "Web Development"
    And User applies Beginner level filter
    And User applies English language filter
    Then Verify at least two courses are displayed
    And Capture second course details
