package com.pom.tests.android;

import com.pom.pages.LeftMenuPage;
import com.pom.pages.LoginPage;
import com.pom.pages.ProductPage;
import com.pom.pages.components.NavBarComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidLoginTests extends BaseAndroidTest {

    private final String USER_NAME = "standard_user";
    private final String PASSWORD = "secret_sauce";
    private final String SYSTEM = "android";

    @Test
    public void androidValidLoginTest() {
        new LoginPage(driver).login(USER_NAME, PASSWORD);
        Assert.assertTrue(new ProductPage(driver).isOnProductsPage(SYSTEM));
    }

    @Test
    public void androidBlockedLoginTest() {
        final String LOCKED_USER = "locked_out_user";
        String EXPECTED_LOCKED_TEXT = "Sorry, this user has been locked out.";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(LOCKED_USER, PASSWORD);
        Assert.assertTrue(loginPage.lockedErrorMessageIsDisplayed(SYSTEM));
        Assert.assertEquals(loginPage.getLockedErrorMessageText(SYSTEM), EXPECTED_LOCKED_TEXT);
    }

    @Test
    public void androidValidLogoutTest() {
        new LoginPage(driver).login(USER_NAME, PASSWORD);
        Assert.assertTrue(new ProductPage(driver).isPageDisplayed());
        new NavBarComponent(driver).clickOnLeftMenuButton(SYSTEM);
        new LeftMenuPage(driver).logout();
        Assert.assertTrue(new LoginPage(driver).isPageDisplayed());
    }

}