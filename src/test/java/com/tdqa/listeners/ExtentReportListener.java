package com.tdqa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ExtentReportListener implements ITestListener, ISuiteListener {
    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ISuite suite) {
        ExtentSparkReporter spark =
            new ExtentSparkReporter("reports/ExtentReport.html");
        spark.config().setDocumentTitle("TD QA Automation Report");
        spark.config().setReportName("Java Selenium Suite");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) { test.pass("Passed"); }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) { test.skip("Skipped"); }

    @Override
    public void onFinish(ISuite suite) { extent.flush(); }
}