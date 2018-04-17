package com.qatest.pages;

import com.qatest.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookAuthPage extends AbstractPage {

    // Variables
    String email = "wasuuppp@rambler.ru";
    String password = "985214521ApE";

    // Elements
    @FindBy(xpath = "//input[@id='email']")
    protected WebElement loginEmail;

    @FindBy(xpath = "//input[@id='pass']")
    protected WebElement loginPass;

    @FindBy(xpath = "//input[@type='submit']")
    protected WebElement loginButton;

    @FindBy(xpath = "//button[@name='__CONFIRM__']")
    protected WebElement submitButton;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public FacebookAuthPage(BaseTest baseTest) {
        super(baseTest);
    }

    /**
     * Method to pass the Facebook credentials
     */
    public void loginWithFacebookProfile() {
        waitUntilElementIsVisible(loginEmail);
        loginEmail.sendKeys(email);
        loginPass.sendKeys(password);
        clickOnElement(loginButton);
    }

}
