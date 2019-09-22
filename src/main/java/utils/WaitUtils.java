package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private WaitUtils() {
    }

    public static void waitUntilVisibilityOfElementLocatedBy(WebDriver driver, By by) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilClickabilityOfElement(WebDriver driver, WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
