package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActionsUtils {

    public static void clickOnElementAndTypeData(WebDriver driver, WebElement element, String data) {
        Actions action = new Actions(driver);
        action.moveToElement(element)
                .click(element)
                .sendKeys(data)
                .build()
                .perform();
    }

    public static void clickOnElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element)
                .click(element)
                .build()
                .perform();
    }

    public static void highlightElement(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", driver.findElement(locator));
    }

    public static void clickElementJs(WebDriver driver, WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", webElement);
    }

}
