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
    protected static WebDriverWait wait;

    @BeforeAll
    public static void before() {
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromdriver"));
        // webdriver.chrome.driver

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 1000);
        driver.get("https://www.rgs.ru");
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("pageTest"));

    }
}
