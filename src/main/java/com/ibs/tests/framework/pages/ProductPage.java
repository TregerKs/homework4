package com.ibs.tests.framework.pages;

import com.ibs.tests.framework.managers.Products;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    protected int iphone;
    protected int iphoneWithGuarantee;
    protected int detroit;
    protected int basket;

    @FindBy(xpath = "//div[@class=\"product-card-top__buy\"]//div[@class=\"product-buy__price\"]")
    private WebElement priceProduct;

    @FindBy(xpath = "//div[@class=\"additional-sales-tabs__titles-wrap\"]/div[2][@class=\"additional-sales-tabs__title\"]")
    private WebElement guarantee;

    @FindBy(xpath = "//label[@class=\"ui-radio__item product-warranty__item product-warranty__item_hit\"]//span[@class=\"ui-radio__content\"]")
    private WebElement checkGuarantee;

    @FindBy(xpath = "//div[@class=\"product-card-top__buy\"]//div[@class=\"product-buy__sub\"]")
    private WebElement changePrice;

    @FindBy(xpath = "//div[@class=\"product-card-top__buy\"]//div[@class=\"product-buy__price product-buy__price_active\"]")
    private WebElement priceWithGuarantee;

    @FindBy(xpath = "//div[@class=\"product-buy product-buy_one-line\"]//button[2]")
    private WebElement buttonBuy;

    @FindBy(xpath = "//span[@class=\"cart-link__price\"]")
    private WebElement priceBasket;

    @FindBy(xpath = "//span[@class=\"cart-link__badge\"]")
    private WebElement checkBasket;

    @FindBy(xpath = "//button[@data-redirect=\"https://www.dns-shop.ru/order/begin/\"]")
    private WebElement basketButton;

    public ProductPage getPriceProductInt(Products product) {
        String text = priceProduct.getText();
        text = text.replaceAll(" ", "");
        text = text.replaceAll("₽", "");
        int price = Integer.parseInt(text);
        switch (product) {
            case IPHONE:
                iphone = price;
                break;
            case IPHONEWITHGUARANTEE:
                iphoneWithGuarantee = price;
                break;
            case DETROIT:
                detroit = price;
                break;
        }
        return pageManager.getProductPage();
    }

    public ProductPage clickGuarantee() {
        guarantee.click();
        return pageManager.getProductPage();
    }

    public ProductPage clickCheckGuarantee() {
        checkGuarantee.click();
        return pageManager.getProductPage();
    }

    public ProductPage isChangePrice() {
        Assertions.assertTrue(changePrice.getText().contains("цена изменена"));
        return pageManager.getProductPage();
    }

    public ProductPage getPriceProductWithGuaranteeInt(Products product) {
        String text = priceWithGuarantee.getText();
        text = text.replaceAll(" ", "");
        text = text.replaceAll("₽", "");
        int price = Integer.parseInt(text);
        switch (product) {
            case IPHONE:
                iphone = price;
                break;
            case IPHONEWITHGUARANTEE:
                iphoneWithGuarantee = price;
                break;
            case DETROIT:
                detroit = price;
                break;
        }
        return pageManager.getProductPage();
    }

    public StartPage clickButtonBuy() {
        buttonBuy.click();
        return pageManager.getStartPage();
    }

    public ProductPage getPriceBasketInt() throws InterruptedException {
        Thread.sleep(3000);
        //waitUtilElementToBeVisible1(priceBasket);
        String text = priceBasket.getText();
        text = text.replaceAll(" ", "");
        text = text.replaceAll("₽", "");
        int price = Integer.parseInt(text);
        int sum = iphoneWithGuarantee + detroit;
        if (sum != price) {
            System.out.println("Что-то пошло не так: сумма в корзине не равна сумме цен товаров");
        }
        return pageManager.getProductPage();
    }

    public BasketPage clickBasketButton() {
        basketButton.click();
        return pageManager.getBasketPage();
    }

}
