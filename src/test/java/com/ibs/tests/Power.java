package com.ibs.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class Power extends BaseTest {
    @Test
    public void test() {
        startPage.inputProduct("Apple iPhone 13 Pro Max 256 ГБ");
        catalogPage.choiceProduct("Apple iPhone 13 Pro Max 256 ГБ голубой");
    }
}
