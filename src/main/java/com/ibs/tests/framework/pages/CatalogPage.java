package com.ibs.tests.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//div[@data-id=\"product\"]")
    private List<WebElement> listProducts;
    //Apple iPhone 13 Pro Max 256 ГБ голубой

    public ProductPage choiceProduct(String product) {
        for (WebElement i : listProducts) {
            if (i.getText().contains(product)) {
                i.click();
                return pageManager.getProductPage();
            }
        }
        return pageManager.getProductPage();
    }
}
