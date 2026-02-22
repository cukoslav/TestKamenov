package com.example.ui.stepdefinitions;

import com.example.ui.drivers.PlaywrightPageProvider;
import com.example.ui.pages.HomePage;
import com.example.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
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

    @When("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
    }

    @And("I enter username {string}")
    public void iEnterUsername(String username) {
        pageProvider.getPage().locator(loginPage.usernameField).fill(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        pageProvider.getPage().locator(loginPage.passwordField).fill(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        pageProvider.getPage().locator(loginPage.loginButton).click();
    }

    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        assertTrue(pageProvider.getPage().locator(homePage.inventoryList).isVisible());
    }
}