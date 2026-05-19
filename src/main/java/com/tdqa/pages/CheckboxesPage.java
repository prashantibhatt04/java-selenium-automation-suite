package com.tdqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage {
    private static final String URL =
        "https://the-internet.herokuapp.com/checkboxes";
    private WebDriver driver;
    private By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) { this.driver = driver; }
    public void load() { driver.get(URL); }
    public List<WebElement> getCheckboxes() {
        return driver.findElements(checkboxes);
    }
    public boolean isChecked(int index) {
        return getCheckboxes().get(index).isSelected();
    }
    public void clickCheckbox(int index) {
        getCheckboxes().get(index).click();
    }
}