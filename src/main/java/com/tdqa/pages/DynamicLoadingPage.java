package com.tdqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoadingPage {
    private static final String URL =
        "https://the-internet.herokuapp.com/dynamic_loading/1";
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By finishElement = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) { this.driver = driver; }
    public void load() { driver.get(URL); }
    public void clickStart() { driver.findElement(startButton).click(); }
    public String getFinishText() {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(finishElement))
            .getText();
    }
    public boolean isFinishElementVisible() {
        return !driver.findElements(finishElement).isEmpty()
            && driver.findElement(finishElement).isDisplayed();
    }
}