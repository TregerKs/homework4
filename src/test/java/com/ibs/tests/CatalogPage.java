package com.ibs.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BaseTest {
    @FindBy(xpath = "//div[@data-id=\"product\"]")
    private List<WebElement> listProducts;
    //Apple iPhone 13 Pro Max 256 ГБ голубой

    public void choiceProduct(String product) {
        for (WebElement i : listProducts) {
            if (i.getText().contains(product)) {
                i.click();
                return;
            }
        }
    }
}
