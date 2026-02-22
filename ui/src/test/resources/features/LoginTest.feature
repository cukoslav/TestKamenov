@ui
Feature: User Login
  As a user
  I want to login to the system
  So that I can access my account

  Background:
    Given the application is running

  Scenario: Successful login with valid credentials
    When I navigate to the login page
    And I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see the dashboard