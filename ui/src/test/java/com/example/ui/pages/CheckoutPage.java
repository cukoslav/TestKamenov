package com.example.ui.pages;

import org.springframework.stereotype.Component;

@Component
public class CheckoutPage {
    public final String addToCartButton = "[data-test='add-to-cart-sauce-labs-backpack']";
    public final String cartIcon = ".shopping_cart_link";
    public final String checkoutButton = "[data-test='checkout']";
    public final String firstNameField = "[data-test='firstName']";
    public final String lastNameField = "[data-test='lastName']";
    public final String zipField = "[data-test='postalCode']";
    public final String continueButton = "[data-test='continue']";
    public final String finishButton = "[data-test='finish']";
    public final String confirmationMessage = "[data-test='complete-header']";
}