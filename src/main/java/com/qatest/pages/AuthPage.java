package com.qatest.pages;

import com.qatest.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class AuthPage extends AbstractPage {

    // Variables
    String buttonTextWrongEmail = "Create account";
    String wrongPassErrorMessage = "Wrong password for the account, please try again or recover your password";

    // Elements

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement authEmail;

    @FindBy(xpath = "//span[@id='id-index-continue-button']/button")
    protected WebElement submitButton;

    @FindBy(xpath = "//span[@id='id-password-login-button']/button")
    protected WebElement loginButton;

    @FindBy(xpath = "//span[@id='id-general-facebook-button']/button")
    protected WebElement facebookButton;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement authPass;

    @FindBy(xpath = "//span[@class='display__inherit notification__text']")
    protected WebElement errorMessage;

    /**
     * Constructor
     * @param baseTest
     */
    public AuthPage(BaseTest baseTest) {
        super(baseTest);
    }

    /**
     * Login with email only
     * @param email
     */
    public void loginToTheAccount(String email) {
        authEmail.sendKeys(email);
        clickOnElement(submitButton);
    }

    /**
     * Login with email and password
     * @param email
     * @param pass
     * @return
     */
    public HomePage loginToTheAccount(String email, String pass) {
        authEmail.sendKeys(email);
        clickOnElement(submitButton);
        waitUntilElementIsVisible(authPass);
        authPass.sendKeys(pass);
        clickOnElement(loginButton);
        return new HomePage(baseTest);
    }

    /**
     * Verify that the button has changed text
     */
    public void verifyTextChangeOnTheButton() {
        Assert.assertEquals("Text on the button is not valid", buttonTextWrongEmail, submitButton.getText());
    }

    /**
     * Verify that the error message is correct
     */
    public void verifyErrorMessage() {
        waitUntilElementIsVisible(errorMessage);
        Assert.assertEquals("Error message is incorrect", wrongPassErrorMessage, errorMessage.getText());
    }

    /**
     * Method to log in with the help of the Facebook account
     * @return
     */
    public HomePage loginWithFacebook() {
        String parentWindow = driver.getWindowHandle();
        clickOnElement(facebookButton);
        Set<String> handles =  driver.getWindowHandles();

        FacebookAuthPage facebookAuthPage =  new FacebookAuthPage(baseTest);

        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                    facebookAuthPage.loginWithFacebookProfile();
                driver.switchTo().window(parentWindow);
            }
        }
        return new HomePage(baseTest);
    }
}
