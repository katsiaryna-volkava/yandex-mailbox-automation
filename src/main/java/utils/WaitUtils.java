package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class WaitUtils {

    public static void waitUntilVisibilityOfElementLocatedBy(WebDriver driver, By by) {
        Wait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
