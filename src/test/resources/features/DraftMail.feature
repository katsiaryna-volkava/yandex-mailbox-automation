Feature: User can save mail as draft

  As a User
  I want to be able to nake draft letters
  So that I could send them later

  Background: User has logged in into mailbox
    Given User is logged in into mailbox account


  Scenario: User can create draft letter
    When I create a letter
    And I close letter without saving it
    Then I find this letter in a draft folder

  @OUTLINE
  Scenario Outline: User can create draft letter with the following data
    When I create a letter with <subject> to <recipient> with <body>
    And I close letter without saving it
    Then I find this letter in a draft folder with <subject> and <body> attributes

    Examples:
      | subject      | recipient | body                     |
      | test         | test      | super test               |
      | another test | test      | wow, the test is passed! |

