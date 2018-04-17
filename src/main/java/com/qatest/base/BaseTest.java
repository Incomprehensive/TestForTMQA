package com.qatest.base;

import com.qatest.pages.AuthPage;
import com.qatest.utils.TestRule;
import com.qatest.utils.YamlOptions;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    //Objects of WebDriver and WebDriverWait
    WebDriver driver;
    WebDriverWait wait;

    //Credentials
    protected String login = YamlOptions.read().getEmail();
    protected String pass = YamlOptions.read().getPass();

    @Rule
    public TestRule testRule = new TestRule(this);

    /**
     * Constructor
     */
    protected BaseTest() {
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.180.1:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/opt/chrome/chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Driver getter
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * WebDriverWait getter
     * @return
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Opens the website
     * @return
     */
    public AuthPage openSite() {
        driver.get(YamlOptions.read().getUrl());
        return new AuthPage(this);
    }
}
