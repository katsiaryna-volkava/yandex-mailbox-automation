package utils;

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
}
