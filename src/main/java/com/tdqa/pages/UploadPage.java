package com.tdqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class UploadPage {
    private static final String URL =
        "https://the-internet.herokuapp.com/upload";
    private WebDriver driver;
    private By fileInput = By.id("file-upload");
    private By submitButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public UploadPage(WebDriver driver) { this.driver = driver; }
    public void load() { driver.get(URL); }
    public void uploadFile(String filename) {
        driver.findElement(fileInput)
            .sendKeys(new File(filename).getAbsolutePath());
        driver.findElement(submitButton).click();
    }
    public String getUploadedFilename() {
        return driver.findElement(uploadedFile).getText();
    }
}