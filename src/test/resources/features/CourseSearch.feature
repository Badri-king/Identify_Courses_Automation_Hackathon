Feature: Searching Course Web Development

  Background:
    Given User launches Coursera website
    Then Verify homepage is displayed

  Scenario: Launch Coursera Website and Verify Search Box
    When Verify search box is visible and enabled

  Scenario: Search for "Web Development" and verify Search
    And User searches for "Web Development"

  @Beginner
  Scenario: Apply Beginner Filter
    And User applies Beginner level filter

  @Language
  Scenario: Apply English Language Filter
    And User applies English language filter
    Then Verify at least two courses are displayed

  @CourseDetails
  Scenario: Capture First Course Details
    Then Verify at least two courses are displayed
    And Capture first course details

  @CourseDetails
  Scenario: Capture Second Course Details
    Then Verify at least two courses are displayed
    And Capture second course details
