Feature: Login functionality

  Scenario: Successful login using username and password
    Given I am on the login page
    When I enter valid username and password
    And I click on Login button
    Then I should be logged in

  Scenario Outline: Unsuccessful login with invalid username
    Given I am on the login page
    When I enter invalid <username> and valid password
    And I click on Login button
    Then I should not be logged in
    And Error message <error> should be displayed

    Examples:
      | username        | error                                                       |
      | locked_out_user | Sorry, this user has been locked out.                       |
      | potato          | Username and password do not match any user in this service |
