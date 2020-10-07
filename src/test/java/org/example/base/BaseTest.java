package org.example.base;

import org.example.constants.constants;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * @author  Ozan Karali
 * @since 07.10.2020
 */

public class BaseTest {

    static WebDriver webDriver=null;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(chromeOptions));
        getWebDriver().navigate().to(constants.WEBLINK);
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

    public void tearDown(){
        getWebDriver().quit();
    }
}
