package com.tdqa.tests;

import com.tdqa.base.BaseDriver;
import com.tdqa.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseDriver {

    @Test(groups = "smoke")
    public void testFinishTextAppearsAfterLoading() {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.load();
        page.clickStart();
        Assert.assertTrue(page.getFinishText().contains("Hello World!"));
    }

    @Test(groups = "regression")
    public void testFinishElementNotVisibleBeforeStart() {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.load();
        Assert.assertFalse(page.isFinishElementVisible());
    }
}