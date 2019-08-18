package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

}
