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

    @And("I add the first product to the cart")
    public void iAddTheFirstProductToTheCart() {
        pageProvider.getPage().locator(checkoutPage.addToCartButton).first().click();
    }

    @And("I navigate to the cart")
    public void iNavigateToTheCart() {
        pageProvider.getPage().locator(checkoutPage.cartIcon).click();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        pageProvider.getPage().locator(checkoutPage.checkoutButton).click();
    }

    @And("I fill checkout info with first name {string} last name {string} and zip {string}")
    public void iFillCheckoutInfo(String firstName, String lastName, String zip) {
        pageProvider.getPage().locator(checkoutPage.firstNameField).fill(firstName);
        pageProvider.getPage().locator(checkoutPage.lastNameField).fill(lastName);
        pageProvider.getPage().locator(checkoutPage.zipField).fill(zip);
        pageProvider.getPage().locator(checkoutPage.continueButton).click();
    }

    @And("I click finish")
    public void iClickFinish() {
        pageProvider.getPage().locator(checkoutPage.finishButton).click();
    }

    @Then("I should see order confirmation")
    public void iShouldSeeOrderConfirmation() {
        String actual = pageProvider.getPage().locator(checkoutPage.confirmationMessage).textContent();
        assertEquals("Thank you for your order!", actual);
    }
}