package com.tdqa.tests;

import com.tdqa.base.BaseDriver;
import com.tdqa.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseDriver {

    @Test(groups = "regression")
    public void testSelectOption1() {
        DropdownPage page = new DropdownPage(driver);
        page.load();
        page.selectByVisibleText("Option 1");
        Assert.assertEquals(page.getSelectedOption(), "Option 1");
    }

    @Test(groups = "regression")
    public void testSelectOption2() {
        DropdownPage page = new DropdownPage(driver);
        page.load();
        page.selectByVisibleText("Option 2");
        Assert.assertEquals(page.getSelectedOption(), "Option 2");
    }
}