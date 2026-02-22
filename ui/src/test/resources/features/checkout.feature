@ui
Feature: Checkout

  Background:
    Given the application is running

  Scenario: Successfully complete an order
    When I navigate to the login page
    And I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    And I add the first product to the cart
    And I navigate to the cart
    And I proceed to checkout
    And I fill checkout info with first name "Samo" last name "Levski" and zip "1000"
    And I click finish
    Then I should see order confirmation