package com.ibs.tests.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"header-menu-wrapper\"]//input[@class=\"ui-input-search__input ui-input-search__input_presearch\"]")
    private WebElement windowSearch;

    //    @FindBy(xpath = "//*[@id=\"uc367d5b9a2774213bb70f7282be43eb3\"]/div/div[2]/span[2]")
//    private WebElement searchButton;
    @Step("Вводим {product} в поисковой строке")
    public CatalogPage inputProduct(String product) {
        fillInputField(windowSearch, product);
        //searchButton.click();
        windowSearch.submit();
        //Assertions.assertTrue(driverManager.getDriver().getTitle().contains(product), "Страница не загрузилась");
        return pageManager.getCatalogPage();
    }

}
