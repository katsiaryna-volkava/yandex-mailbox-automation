package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitForPageToBeLoaded();
        initializePageFactory();
    }

    private void initializePageFactory() {
        PageFactory.initElements(driver, this);
    }

    protected abstract void waitForPageToBeLoaded();

    protected abstract void waitForElementToBeLoaded(WebElement element);

    protected void resfreshCurrentPage() {
        new Actions(driver).sendKeys(Keys.F5).build().perform();
    }

}
