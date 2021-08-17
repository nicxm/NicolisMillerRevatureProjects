# Comment
Feature: Wikipedia Language links work

  #each sceneario will connect to a user story
  Scenario: English Wikipedia works
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks English
    Then The Guest should be on the English Home Page
