package com.tdqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private static final String URL =
        "https://the-internet.herokuapp.com/dropdown";
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) { this.driver = driver; }
    public void load() { driver.get(URL); }
    public void selectByVisibleText(String text) {
        new Select(driver.findElement(dropdown)).selectByVisibleText(text);
    }
    public String getSelectedOption() {
        return new Select(driver.findElement(dropdown))
            .getFirstSelectedOption().getText();
    }
}