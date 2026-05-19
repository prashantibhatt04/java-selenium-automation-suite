package com.tdqa.tests;

import com.tdqa.base.BaseDriver;
import com.tdqa.pages.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseDriver {

    @Test(groups = "regression")
    public void testFirstCheckboxUncheckedByDefault() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.load();
        Assert.assertFalse(page.isChecked(0));
    }

    @Test(groups = "regression")
    public void testSecondCheckboxCheckedByDefault() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.load();
        Assert.assertTrue(page.isChecked(1));
    }

    @Test(groups = "regression")
    public void testCanCheckFirstCheckbox() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.load();
        page.clickCheckbox(0);
        Assert.assertTrue(page.isChecked(0));
    }
}