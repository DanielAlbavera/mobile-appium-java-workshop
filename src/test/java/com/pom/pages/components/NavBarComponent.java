package com.pom.pages.components;

import com.pom.pages.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavBarComponent extends BasePage {

    private final AppiumBy iosShoppingCartButton = (AppiumBy) AppiumBy.accessibilityId("test-Cart");
    private final By iosLeftMenuButton = By.xpath("//*[@name='test-Menu']");
    private final AppiumBy androidLeftMenuButton = (AppiumBy) AppiumBy.accessibilityId("test-Menu");

    public NavBarComponent(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public  boolean isPageDisplayed() {
        return driver.findElement(iosLeftMenuButton).isDisplayed();
    }

    public void clickOnShoppingCartButton() {
        driver.findElement(iosShoppingCartButton).click();
    }

    public void clickOnLeftMenuButton(String system) {
        if (system.equals("android")) driver.findElement(androidLeftMenuButton).click();
        if (system.equals("ios")) driver.findElement(iosLeftMenuButton).click();
    }

}
