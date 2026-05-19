package com.tdqa.tests;

import com.tdqa.base.BaseDriver;
import com.tdqa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {

    @Test(groups = "smoke")
    public void testValidLogin() {
        LoginPage page = new LoginPage(driver);
        page.load();
        page.enterUsername("tomsmith");
        page.enterPassword("SuperSecretPassword!");
        page.clickLogin();
        Assert.assertTrue(
            page.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test(groups = "regression")
    public void testInvalidLogin() {
        LoginPage page = new LoginPage(driver);
        page.load();
        page.enterUsername("wronguser");
        page.enterPassword("wrongpass");
        page.clickLogin();
        Assert.assertTrue(
            page.getFlashMessage().contains("Your username is invalid!"));
    }

    @Test(groups = "regression")
    public void testEmptyCredentials() {
        LoginPage page = new LoginPage(driver);
        page.load();
        page.clickLogin();
        Assert.assertTrue(
            page.getFlashMessage().contains("Your username is invalid!"));
    }
}