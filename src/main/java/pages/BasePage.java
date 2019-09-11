package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitForPageToBeLoaded();
        initializePageFactory();
    }

    private void initializePageFactory() {
        PageFactory.initElements(driver, this);
    }

    protected abstract void waitForPageToBeLoaded();

    protected void resfreshCurrentPage() {
        new Actions(driver).sendKeys(Keys.F5).build().perform();
    }

}
