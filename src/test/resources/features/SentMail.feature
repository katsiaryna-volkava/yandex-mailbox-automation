Feature: User can send letter

  As a User
  I want to be able to send letters
  So that other users could read them

  Background: User has created a draft mail
    Given User is logged in into mailbox account
    And A draft letter is created


  Scenario: User can create draft letter
    When I send letter
    Then I find it in a sent mail folder
