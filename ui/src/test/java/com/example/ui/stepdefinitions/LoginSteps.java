package com.example.ui.stepdefinitions;

import com.example.ui.drivers.PlaywrightPageProvider;
import com.example.ui.pages.HomePage;
import com.example.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
public class LoginSteps {

    private final PlaywrightPageProvider pageProvider;
    private final LoginPage loginPage;
    private final HomePage homePage;

    @Given("the application is running")
    public void theApplicationIsRunning() {
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsIn(String username, String password) {
        pageProvider.getPage().locator(loginPage.usernameField).fill(username);
        pageProvider.getPage().locator(loginPage.passwordField).fill(password);
        pageProvider.getPage().locator(loginPage.loginButton).click();
    }

    @Then("the user should see the dashboard")
    public void theUserShouldSeeTheDashboard() {
        assertTrue(pageProvider.getPage().locator(homePage.inventoryList).isVisible());
    }
}