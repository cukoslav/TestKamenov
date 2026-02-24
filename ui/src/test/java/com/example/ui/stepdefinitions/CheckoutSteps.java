package com.example.ui.stepdefinitions;

import com.example.ui.drivers.PlaywrightPageProvider;
import com.example.ui.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class CheckoutSteps {

    private final PlaywrightPageProvider pageProvider;
    private final CheckoutPage checkoutPage;

    @And("the user adds the first product to the cart")
    public void theUserAddsTheFirstProductToTheCart() {
        pageProvider.getPage().locator(checkoutPage.addToCartButton).first().click();
    }

    @And("the user navigates to the cart")
    public void theUserNavigatesToTheCart() {
        pageProvider.getPage().locator(checkoutPage.cartIcon).click();
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        pageProvider.getPage().locator(checkoutPage.checkoutButton).click();
    }

    @And("the user fills checkout info with first name {string} last name {string} and zip {string}")
    public void theUserFillsCheckoutInfo(String firstName, String lastName, String zip) {
        pageProvider.getPage().locator(checkoutPage.firstNameField).fill(firstName);
        pageProvider.getPage().locator(checkoutPage.lastNameField).fill(lastName);
        pageProvider.getPage().locator(checkoutPage.zipField).fill(zip);
        pageProvider.getPage().locator(checkoutPage.continueButton).click();
    }

    @And("the user clicks finish")
    public void theUserClicksFinish() {
        pageProvider.getPage().locator(checkoutPage.finishButton).click();
    }

    @Then("the user should see order confirmation")
    public void theUserShouldSeeOrderConfirmation() {
        String actual = pageProvider.getPage().locator(checkoutPage.confirmationMessage).textContent();
        assertEquals("Thank you for your order!", actual);
    }
}