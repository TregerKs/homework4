package com.ibs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StartPage extends BaseTest {
   // public static WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"u55de1e4cd0324185a34f9ff42cc4c1bd\"]/div/input")
    private WebElement windowSearch;

    @FindBy(xpath = "//*[@id=\"uc367d5b9a2774213bb70f7282be43eb3\"]/div/div[2]/span[2]")
    private WebElement searchButton;

    public void inputProduct(String product) {
        windowSearch.sendKeys(product);
        searchButton.click();
    }
}
