@ui
Feature: Login

  Background:
    Given the application is running

  Scenario: Successful login with valid credentials
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should see the dashboard