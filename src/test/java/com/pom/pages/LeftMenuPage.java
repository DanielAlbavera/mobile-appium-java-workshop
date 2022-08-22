package com.pom.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LeftMenuPage extends BasePage {

    private final AppiumBy logoutButton = (AppiumBy) AppiumBy.accessibilityId("test-LOGOUT");

    public LeftMenuPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public  boolean isPageDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

}
