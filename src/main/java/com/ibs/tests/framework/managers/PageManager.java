package com.ibs.tests.framework.managers;

import com.ibs.tests.framework.pages.BasketPage;
import com.ibs.tests.framework.pages.CatalogPage;
import com.ibs.tests.framework.pages.ProductPage;
import com.ibs.tests.framework.pages.StartPage;

public class PageManager {
    private static PageManager INSTANCE = null;

    private StartPage startPage;
    private CatalogPage catalogPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public CatalogPage getCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        return catalogPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public BasketPage getBasketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }
}
