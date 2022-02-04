package com.ibs.tests;

import com.ibs.tests.framework.managers.Products;
import org.junit.jupiter.api.Test;


public class Power extends BaseTests {


    @Test
    public void test() throws InterruptedException {
        pageManager.getStartPage()
                .inputProduct("Apple iPhone 13 Pro Max 256 ГБ")
                .choiceProduct("Apple iPhone 13 Pro Max 256 ГБ голубой")
                .getPriceProductInt(Products.IPHONE)
                .clickGuarantee()
                .clickCheckGuarantee()
                .isChangePrice()
                .getPriceProductWithGuaranteeInt(Products.IPHONEWITHGUARANTEE)
                .clickButtonBuy()
                .inputProduct("Detroit")
                .choiceProduct("Игра Detroit: Стать человеком")
                .getPriceProductInt(Products.DETROIT)
                .clickButtonBuy();
        pageManager.getProductPage().getPriceBasketInt();
        pageManager.getProductPage().clickBasketButton()
                .isCheckGuarantee("Apple iPhone 13 Pro Max 256 ГБ голубой")
                .checkProductsPrice();
        pageManager.getBasketPage().deleteProduct("Игра Detroit: Стать человеком")
                .checkProductsPrice()
                .addProduct("Apple iPhone 13 Pro Max 256 ГБ голубой", 2)
                .checkProductsPrice();
        pageManager.getBasketPage().returnProduct()
                .checkProductsPrice();


    }
}
