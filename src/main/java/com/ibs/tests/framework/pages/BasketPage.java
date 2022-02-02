package com.ibs.tests.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"cart-items__wrapper\"]")
    private List<WebElement> listProductsInBasket;

    @FindBy(xpath = "//span[@class=\"base-ui-radio-button__icon base-ui-radio-button__icon_checked\"]")
    private WebElement checkGuarantee;

    public BasketPage isCheckGuarantee(String product) {
        for (WebElement i : listProductsInBasket) {
            if (i.getText().contains(product)) {
                //if (elementHasClass( "base-ui-radio-button__icon base-ui-radio-button__icon_checked"))
                if (elementHasClass( "base-ui-radio-button__icon_checked"))
                {
                    return pageManager.getBasketPage();
                } else {
                    System.out.println("Гарантия не выбрана");
                    return pageManager.getBasketPage();
                }
            }
        }
        return pageManager.getBasketPage();
    }

    public boolean elementHasClass(String active) {
        String a = checkGuarantee.getAttribute("class");
        return checkGuarantee.getAttribute("class").contains(active);
    }

}
