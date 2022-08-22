package com.pom.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    private final By androidProductsLabel = By.xpath("//*[@text='PRODUCTS']");
    private final By iosProductsLabel = By.xpath("//*[@name='PRODUCTS']");

    private final By iosFirstAddToCartButton = By.xpath("(//*[@label='ADD TO CART'])[2]");
    private final By androidFirstAddToCartButton = By.xpath("(//*[@text='ADD TO CART'])[1]");

    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public  boolean isPageDisplayed() {
        return driver.findElement(androidProductsLabel).isDisplayed();
    }

    public boolean isOnProductsPage(String system) {
        //Create an instance of an explicit wait so that we can dynamically wait for an element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //wait for the product field to be visible and store that element into a variable
        try {
            if (system.equals("android")) wait.until(ExpectedConditions.visibilityOfElementLocated(androidProductsLabel));
            if (system.equals("ios")) wait.until(ExpectedConditions.visibilityOfElementLocated(iosProductsLabel));
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

}
