Feature:  Look for Language Learning, Extract all the languages and different levels

  Background:
    Given user should navigate to coursera page
    When user clicks LanguageLearning option in homepage

  Scenario: Navigate to Language Learning Section
    Then checks it displays LanguageLearning page


  Scenario: Extract All credentials and courses
    When user extract the total count of the courses and credentials


  Scenario: Count Total Languages
    When user Verify total number of languages displayed and display languages


    @count
  Scenario: Count Total Levels
    When user Verify level count and display results and extract levels.
