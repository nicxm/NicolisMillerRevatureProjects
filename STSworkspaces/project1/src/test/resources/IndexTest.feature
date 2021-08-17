Feature: Index Works

  #Each Scenario will connect to a user story
  Scenario: Login works
    Given The Employee is on the Index
    When Enters their username
    And Enters their password
    And Clicks login
    Then They should be logged in
    
    Scenario: Submit Form
    Given The Employee is on the Index and is logged in
    When They enter their date start
    And They enter their date end
    And They enter their location
    And They enter their description
    And They enter their cost
    And They enter their reason
    And Clicks Submit Tution Form
    Then The Form should submit
