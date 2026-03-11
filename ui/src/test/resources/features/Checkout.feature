@ui
Feature: Checkout

  Background:
    Given the application is running

  Scenario: Successfully complete an order
    When the user logs in with username "standard_user" and password "secret_sauce"
    And the user adds the first product to the cart
    And the user navigates to the cart
    And the user proceeds to checkout
    And the user fills checkout info with first name "Samo" last name "Levski" and zip "1000"
    And the user clicks finish
    Then the user should see order confirmation