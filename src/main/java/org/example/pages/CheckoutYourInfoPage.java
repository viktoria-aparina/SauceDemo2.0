package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutYourInfoPage extends BasePage {

    private static final By TITLE = By.cssSelector(".title");

    public CheckoutYourInfoPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }
}
