package com.ibs.tests;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static StartPage startPage;
    public static CatalogPage catalogPage;
    @BeforeAll
    public void before() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromdriver"));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10, 500);
        driver.get(ConfProperties.getProperty("pageTest"));
    }
}

