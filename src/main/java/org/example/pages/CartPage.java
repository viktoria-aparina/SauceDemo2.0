package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy (css = ".title")
    private WebElement title;
    private final By productItemInCart = By.xpath("//div[@class = 'inventory_item_name']");
    private final By countingShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private String removeButton = "//div[text()='%s']/ancestor::div[@class='cart_item']//button";
    private String countOfProductsForm = "//div[text()='']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public WebElement getTitle() {
        return title;
    }

    public String getCountOfProducts() {
        return driver.findElement(By.xpath(countOfProductsForm)).getText();
    }

    public void changeCountOfProductsInCart(String productNameFirst, String countProducts) {
        By fullLocatorForCountOfProducts = By.xpath(String.format(countOfProductsForm, productNameFirst));
        driver.findElement(fullLocatorForCountOfProducts).clear();
        driver.findElement(fullLocatorForCountOfProducts).sendKeys(countProducts);
    }

    public void clickRemove(String productName) {
        By fullLocatorForRemoveButton = By.xpath(String.format(removeButton, productName));
        driver.findElement(fullLocatorForRemoveButton).click();
    }

    public void clickCountingShoppingButton() {
        driver.findElement(countingShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public List<WebElement> getAllProductsInCart() {
        return driver.findElements(productItemInCart);
    }
}

