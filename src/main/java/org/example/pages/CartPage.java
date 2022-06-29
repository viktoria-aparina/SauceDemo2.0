package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private static final By TITLE = By.cssSelector(".title");
    private final By countingShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private String countOfProductsForm = "//div[text()='']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public String getCountOfProducts() {
        return driver.findElement(By.xpath(countOfProductsForm)).getText();
    }

    public void changeCountOfProductsInCart(String productName, String countProducts) {
        By fullLocatorForCountOfProducts = By.xpath(String.format(countOfProductsForm, productName));
        driver.findElement(fullLocatorForCountOfProducts).clear();
        driver.findElement(fullLocatorForCountOfProducts).sendKeys(countProducts);
    }

    public void clickRemove(String productName) {
        String removeButton = "//div[text()='%s']/ancestor::div[@class='cart_item']//button";
        By fullLocatorForRemoveButton = By.xpath(String.format(removeButton, productName));
        driver.findElement(fullLocatorForRemoveButton).click();
    }

    public void clickCountingShoppingButton() {
        driver.findElement(countingShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}
