package utils;

import driver.DriverSingleton;
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
        log.info(String.format("Test %s has started", iTestResult.getMethod().getMethodName()));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("Test %s has started", iTestResult.getMethod().getMethodName()));
    }

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
        log.error(String.format("Test %s has failed", iTestResult.getMethod().getMethodName()));
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.warn(String.format("Test %s has skipped", iTestResult.getMethod().getMethodName()));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error(String.format("Failed to save screenshot: %s", e.getLocalizedMessage()));
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}