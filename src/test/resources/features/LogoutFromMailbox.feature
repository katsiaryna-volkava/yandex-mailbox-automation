Feature: User can logout from mailbox

  As a User
  I want to be able to logout from current mailbox
  So that I would login to another one

  Background: User has logged in into mailbox account
    Given User is logged in into mailbox account

  @SMOKE
  Scenario: User can logout from current mailbox account
    When I logout from current account
    Then I'm on a login page
