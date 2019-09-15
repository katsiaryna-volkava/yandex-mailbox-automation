package utils;

import com.codeborne.selenide.testng.ScreenShooter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        log.info("----------------------------------------------------------------------------");
        log.info("Test with name: " + iTestResult.getMethod().getMethodName() + " has started");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test with name: " + iTestResult.getMethod().getMethodName() + " has passed");

    }

    public void onTestFailure(ITestResult iTestResult) {

        log.info("Test with name: " + iTestResult.getMethod().getMethodName() + " has failed");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test with name: " + iTestResult.getMethod().getMethodName() + " has skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
