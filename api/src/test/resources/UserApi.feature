@api
Feature: User API

  Scenario: A new user is created and can be retrieved by username
    Given a user with random data exists
    When the user is created via POST request
    Then the creation should be successful
    When the user is retrieved via GET request by username
    Then the retrieved user should match the created user using SoftAssert
    And the retrieved user should match the created user using RecursiveComparison