package org.example.pages;

import org.example.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

import static org.example.steps.LoginSteps.STANDARD_USER_PROPERTIES;

public class LoginPage extends BasePage {

    private static final String LOGIN_BUTTON_ID = "login-button";

    private static final String URL = "login.url";
    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = LOGIN_BUTTON_ID)
    private WebElement loginButton;

    @FindBy(css = "[data-test=error]")
    private WebElement error;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
       driver.get(BASE_URL);
    }

    public void fillInUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void fillInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void submitForm() {
        loginButton.submit();
    }

    public String getError() {
        return error.getText();
    }
}
