package com.qatest.pages;

import com.qatest.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    String TITLE = "TemplateMonster Registration";
    protected String facebookName = "Anton Pelianskij";

    @FindBy(xpath = "//span[@class='user-account-info__name t1']")
    protected WebElement accountName;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public HomePage(BaseTest baseTest) {
        super(baseTest);
    }

    /**
     * Verifies the title of the page
     */
    public void verifyTitle() {
        Assert.assertEquals("Titles do not match", TITLE, baseTest.getDriver().getTitle());
    }

    /**
     * Method to verify the account name
     * @param name
     */
    public void verifyAccountName(String name) {
        waitUntilElementIsVisible(accountName);
        Assert.assertEquals("Account name does not match", name, accountName.getText());
    }

    /**
     * Getter for a Facebook name to verify if we have logged in with the correct profile
     * @return
     */
    public String getFacebookName(){
        return facebookName;
    }
}
