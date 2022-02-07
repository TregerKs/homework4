package com.ibs.tests;

import com.ibs.tests.framework.managers.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class PowerTest extends BaseTests {


    @Test
    @Tag("DnsTest")
    @DisplayName("Тест по сайту DNS")
    public void test() {
        pageManager.getStartPage()
                .inputProduct("Apple iPhone 13 Pro Max 256 ГБ");
//                .choiceProduct("Apple iPhone 13 Pro Max 256 ГБ голубой")
//                .getPriceProductInt(Products.IPHONE)
//                .clickGuarantee()
//                .clickCheckGuarantee()
//                .isChangePrice()
//                .getPriceProductWithGuaranteeInt(Products.IPHONEWITHGUARANTEE)
//                .clickButtonBuy()
//                .inputProduct("Detroit")
//                .choiceProduct("Игра Detroit: Стать человеком")
//                .getPriceProductInt(Products.DETROIT)
//                .clickButtonBuy();
//        pageManager.getProductPage().checkPriceBasketWithConstants()
//                .clickBasketButton()
//                .isCheckGuarantee("Apple iPhone 13 Pro Max 256 ГБ голубой")
//                .checkProductsPrice()
//                .deleteProduct("Игра Detroit: Стать человеком")
//                .checkProductsPrice()
//                .addProduct("Apple iPhone 13 Pro Max 256 ГБ голубой", 2)
//                .checkProductsPrice()
//                .returnProduct()
//                .checkProductsPrice();
    }
}
