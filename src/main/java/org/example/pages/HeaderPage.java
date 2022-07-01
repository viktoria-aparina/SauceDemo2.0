package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private final By cartButton = By.cssSelector(".shopping_cart_link");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
}
