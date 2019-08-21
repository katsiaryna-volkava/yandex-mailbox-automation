package pages.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WaitUtils;

public class LogOffPage extends BasePage {

    private static final String LOGIN_TO_ANOTHER_ACCOUNT_CONTROL = "//a[contains(@class,'account-list__sign-in-button')]";

    public LogOffPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = LOGIN_TO_ANOTHER_ACCOUNT_CONTROL)
    private WebElement loginToAnotherAccountButton;


    public boolean checkThatYouHaveLoggedOff() {
        return loginToAnotherAccountButton.isDisplayed();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(LOGIN_TO_ANOTHER_ACCOUNT_CONTROL));
    }
}
