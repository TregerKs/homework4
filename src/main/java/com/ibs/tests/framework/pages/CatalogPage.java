package com.ibs.tests.framework.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//div[@data-id=\"product\"]")
    private List<WebElement> listProducts;

    @Step("Выбираем {product} из списка")
    public ProductPage choiceProduct(String product) {
        for (WebElement i : listProducts) {
            waitUtilElementToBeClickable(i);
            if (i.getText().contains(product)) {
                i.click();
                return pageManager.getProductPage();
            }
        }
        return pageManager.getProductPage();
    }
}
