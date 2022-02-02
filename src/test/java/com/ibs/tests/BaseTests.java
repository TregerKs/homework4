package com.ibs.tests;

import com.ibs.tests.framework.managers.DriverManager;
import com.ibs.tests.framework.managers.InitManager;
import com.ibs.tests.framework.managers.PageManager;
import com.ibs.tests.framework.managers.ConfProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    private final DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initDriverSetting();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(ConfProperties.getProperty("pageTest"));
    }

    @AfterEach
    public void after() {
        driverManager.getDriver().quit();
    }
}
