package com.ibs.tests.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {

    private int quantityGuaranteeInt;

    @FindBy(xpath = "//div[@class=\"cart-items__wrapper\"]")
    private List<WebElement> listProductsInBasket;

    @FindBy(xpath = "//div[@class=\"cart-items__wrapper\"]//span[@class=\"price__current\"]")
    private List<WebElement> listPricesInBasket;

    @FindBy(xpath = "//span[@class=\"base-ui-radio-button__icon base-ui-radio-button__icon_checked\"]")
    private WebElement checkGuarantee;

    @FindBy(xpath = "//span[@class=\"additional-warranties-row__price\"]")
    private WebElement priceGuarantee;

    @FindBy(xpath = "//button[@class=\"menu-control-button remove-button\"]")
    private WebElement deleteList;

    @FindBy(xpath = "//button[@class=\"count-buttons__button count-buttons__button_plus\"]")
    private WebElement addProduct;

    @FindBy(xpath = "//div[@class=\"cart-tab-menu\"]//span[@class=\"restore-last-removed\"]")
    private WebElement returnProduct;

    @FindBy(xpath = "//div[@class=\"total-amount__count\"]")
    private WebElement quantityGuarantee;

    @Step("Проверяем, что выбрана гарантия у {product}")
    public BasketPage isCheckGuarantee(String product) {
        for (WebElement i : listProductsInBasket) {
            if (i.getText().contains(product)) {
                //if (elementHasClass( "base-ui-radio-button__icon base-ui-radio-button__icon_checked"))
                if (elementHasClass("base-ui-radio-button__icon_checked")) {
                    return pageManager.getBasketPage();
                } else {
                    System.out.println("Гарантия не выбрана");
                    return pageManager.getBasketPage();
                }
            }
        }
        return pageManager.getBasketPage();
    }

    @Step("Проверяем, что у класса элемента есть атрибут {active}")
    public boolean elementHasClass(String active) {
        return checkGuarantee.getAttribute("class").contains(active);
    }

    public BasketPage checkQuantityGuarantee(){
        quantityGuaranteeInt = 0;
        String str = quantityGuarantee.getText();
        //str = str.replaceAll("Итого: ", "");
        char ch = str.charAt(7);
        quantityGuaranteeInt = Character.getNumericValue(ch);
        return pageManager.getBasketPage();
    }

    @Step("Считаем сумму товаров в корзине")
    public BasketPage checkProductsPrice() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sumBasket;
        int sumProduct = 0;
        for (WebElement i : listPricesInBasket) {
            String priceStr = i.getText();
            priceStr = priceStr.replaceAll(" ", "");
            priceStr = priceStr.replaceAll("₽", "");
            int price = Integer.parseInt(priceStr);
            //  if (price == pageManager.getProductPage().iphone || price == pageManager.getProductPage().detroit || price == pageManager.getProductPage().iphoneWithGuarantee) {
            sumProduct += price;
//                System.out.println("Цена совпала");
//            } else {
//                System.out.println("Цена не совпала");
//                return pageManager.getBasketPage();
//            }
        }
        checkQuantityGuarantee();
        String priceStr = priceGuarantee.getText();
        priceStr = priceStr.replaceAll(" ", "");
        priceStr = priceStr.replaceAll("₽", "");
        priceStr = priceStr.replaceAll("&nbsp,", "");
        int price = Integer.parseInt(priceStr);
        sumProduct += price*quantityGuaranteeInt;
        sumBasket = pageManager.getProductPage().getPriceBasketInt();
        if (sumProduct == sumBasket) {

            System.out.println("Сумма в корзине верная " + sumBasket + "товаров на " + sumProduct);
        } else {
            System.out.println("Сумма в корзине неверная" + sumBasket + "товаров на " + sumProduct);
        }
        return pageManager.getBasketPage();
    }

    @Step("Удаляем {name}")
    public BasketPage deleteProduct(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement i : listProductsInBasket) {
            if (i.getText().contains(name)) {
                WebElement deleteProduct = i.findElement(By.xpath("./../..//button[contains(@class, \"remove-button\")]"));
                deleteProduct.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Assertions.assertTrue(listProductsInBasket.size() == 1, "Удаление не прошло");
                break;
            }
        }
        return pageManager.getBasketPage();
    }

    @Step("Добавляем {name} {quantity} раз")
    public BasketPage addProduct(String name, int quantity) {
        for (int i = 0; i < quantity; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        for (WebElement i : listProductsInBasket) {
//            if (i.getText().contains(name)) {
//                WebElement addProduct = i.findElement(By.xpath("./../..//button[contains(@class, \"count-buttons__icon-plus\")]"));
            waitUtilElementToBeClickable(addProduct);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addProduct.click();
//                System.out.println("Зашел в добавление");
//                break;
//            }
//        }
        }
        return pageManager.getBasketPage();
    }

    @Step("Возвращаем удаленный товар в корзину")
    public BasketPage returnProduct() {
        waitUtilElementToBeClickable(returnProduct);
        returnProduct.click();
        return pageManager.getBasketPage();
    }

}


