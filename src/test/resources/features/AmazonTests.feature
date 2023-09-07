
Feature: Amazon login Tests

  @Login
  Scenario: Login to Amazon India
    Given User is on login page
    When user enters username as "vdinuu@live.com" and password as "test123"
#    And clicks on Submit button
#    Then Login should not be successful

#  @Login
#  Scenario: Second Login to Amazon India
#    Given User is on login page
#    When user enters username as "vdinuu@live.com" and password as "testing01"
#    And clicks on Submit button
#    Then Login should not be successful
#    And Accounts banner is displayed