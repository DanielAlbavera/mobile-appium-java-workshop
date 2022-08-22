package com.pom.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final AppiumBy usernameInput = (AppiumBy) AppiumBy.accessibilityId("test-Username");
    private final AppiumBy passwordInput = (AppiumBy) AppiumBy.accessibilityId("test-Password");
    private final AppiumBy submitButton = (AppiumBy) AppiumBy.accessibilityId("test-LOGIN");
    private final AppiumBy iosLockedErrorMessage = (AppiumBy) AppiumBy.accessibilityId("test-Error message");
    private final By androidLockedErrorMessage = By.xpath("//*[@content-desc='test-Error message']/*");

    public LoginPage(AppiumDriver driver) { super(driver); }

    @Override
    public  boolean isPageDisplayed() {
        return driver.findElement(submitButton).isDisplayed();
    }
    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public boolean lockedErrorMessageIsDisplayed(String system) {
       if (system.equals("android")) return driver.findElement(androidLockedErrorMessage).isDisplayed();
       if (system.equals("ios")) return driver.findElement(iosLockedErrorMessage).isDisplayed();
       return false;
    }

    public String getLockedErrorMessageText(String system) {
        if (system.equals("android")) return driver.findElement(androidLockedErrorMessage).getAttribute("text");
        if (system.equals("ios")) return driver.findElement(iosLockedErrorMessage).getAttribute("label");
        return "Invalid System";
    }

}
