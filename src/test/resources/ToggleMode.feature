Feature: Toggle Theme
  In order to be able to switch between dark and light theme
  As a user
  I want to customize the app's appearance to my preference

  Scenario: Toggle App Theme
    Given the app is in the initial mode
    When I click the toggle theme button
    Then the app should switch to a different theme mode


  Scenario: Theme persistence after app restart
    Given the app's theme has changed
    When I refresh the app
    Then the app should still be same theme mode