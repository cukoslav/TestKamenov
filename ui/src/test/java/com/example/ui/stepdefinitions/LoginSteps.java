package com.example.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginSteps {
    @Given("the application is running")
    public void theApplicationIsRunning() {
        System.out.println("The Application is running");
    }

    @When("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.println("Open Login page");
    }

    @And("I enter username {string}")
    public void iEnterUsername(String username) {
        System.out.println("Enter username: " + username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        System.out.println("Enter password: " + password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        System.out.println("Click the Login button");
    }

    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        System.out.println("I see the Dashboard");
    }
}