package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void cartButtonIsWorking() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        headerPage.clickCartButton();
        assertTrue(cartPage.getTitle().isDisplayed(), "User didn't go to the cart page");
    }

    @Test
    public void countOfProductsIsChangeable() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.changeCountOfProductsInCart("Sauce Labs Fleece Jacket", "3");
        Assert.assertEquals(cartPage.getCountOfProducts(), "3", "Count of products wasn't change in the cart");
    }

    @Test
    public void removeButtonIsWorking() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.getAllProductsInCart();
        cartPage.clickRemove("Sauce Labs Fleece Jacket");
        cartPage.getAllProductsInCart();
        Assert.assertEquals(cartPage.getAllProductsInCart().size(), "1", "Product wasn't remove from cart" );
    }

    @Test
    public void countingShoppingButtonIsWorking() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.clickCountingShoppingButton();
        Assert.assertTrue(productsPage.getTitle().isDisplayed(), "User can't return to product page");
    }

    @Test
    public void checkoutButtonIsWorking() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.getTitle().isDisplayed(), "User didn't go to the checkout page");
    }
}
