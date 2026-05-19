package com.tdqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static final String URL =
        "https://the-internet.herokuapp.com/login";
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) { this.driver = driver; }
    public void load() { driver.get(URL); }
    public void enterUsername(String u) { driver.findElement(usernameField).sendKeys(u); }
    public void enterPassword(String p) { driver.findElement(passwordField).sendKeys(p); }
    public void clickLogin() { driver.findElement(loginButton).click(); }
    public String getFlashMessage() { return driver.findElement(flashMessage).getText(); }
}