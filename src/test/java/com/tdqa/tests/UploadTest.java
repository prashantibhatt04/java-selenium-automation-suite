package com.tdqa.tests;

import com.tdqa.base.BaseDriver;
import com.tdqa.pages.UploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends BaseDriver {

    @Test(groups = "smoke")
    public void testFileUploadSuccess() {
        UploadPage page = new UploadPage(driver);
        page.load();
        page.uploadFile("test_upload.txt");
        Assert.assertTrue(
            page.getUploadedFilename().contains("test_upload.txt"));
    }
}