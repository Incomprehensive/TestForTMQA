package com.qatest.test;

import com.qatest.base.BaseTest;
import com.qatest.pages.AuthPage;
import com.qatest.pages.FacebookAuthPage;
import com.qatest.pages.HomePage;
import org.junit.Test;

public class LoginTestFacebook extends BaseTest {

    @Test
    public void testLoginTestFacebook() {

        // Open Site
        AuthPage authPage = openSite();

        // Enter the correct credentials
        HomePage homePage = authPage.loginWithFacebook();

        //Verify the account name
        homePage.verifyAccountName(homePage.getFacebookName());

    }

}
