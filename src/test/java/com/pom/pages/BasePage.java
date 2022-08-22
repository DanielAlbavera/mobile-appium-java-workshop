package com.pom.pages;

import io.appium.java_client.AppiumDriver;

public abstract class BasePage {

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isPageDisplayed();

}
