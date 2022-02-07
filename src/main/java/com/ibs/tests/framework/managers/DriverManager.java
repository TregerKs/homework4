package com.ibs.tests.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {

    private static DriverManager driverManager  = null;

    private WebDriver driver;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (driverManager  == null) {
            driverManager  = new DriverManager();
        }
        return driverManager ;
    }

    public WebDriver getDriver(){
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver(){
//        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
//        ChromeOptions ops = new ChromeOptions();
//        ops.addArguments("--disable-notifications");
//        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("81.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);


        try {
            driver = new RemoteWebDriver(
                    URI.create("http://161.35.196.82:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void quitDriver() {
        driver.manage().deleteAllCookies();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
