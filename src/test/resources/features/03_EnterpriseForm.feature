Feature: Coursera Enterprise Form Validation

  Background:
    Given User launches Coursera website
    Then Verify homepage is displayed

  Scenario: Open For Enterprise
    When Navigate to For Enterprise section
    Then Verify For Enterprise page is displayed

  Scenario: Navigate to Ready to Transform form
    When Navigate to For Enterprise section
    And Navigate to form section
    Then Verify form is displayed

  Scenario: Fill form with invalid email
    When Navigate to For Enterprise section
    And Navigate to form section
    And Enter all mandatory details with invalid email

  Scenario: Capture invalid email error message
    When Navigate to For Enterprise section
    And Navigate to form section
    And Enter all mandatory details with invalid email
    And Submit form
    Then Capture and display email validation error message