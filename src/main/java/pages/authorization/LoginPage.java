package pages.authorization;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    private static final String LOGIN_INPUT = "//input[@type='text' and @name='login']";
    private static final String PASSWORD_INPUT = "//input[@type='password' and @name='passwd']";
    private static final String PROCEED_BUTTON = "//button[@type='submit']";

    String loginData = TestData.getLoginNameValue();
    String passwordData = TestData.getPasswordValue();

    @FindBy(xpath = LOGIN_INPUT)
    private WebElement loginField;

    @FindBy(xpath = PASSWORD_INPUT)
    private WebElement passwordField;

    @FindBy(xpath = PROCEED_BUTTON)
    private WebElement proceedButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CommonPage enterCredentials() {
        userEntersLoginName();
        userEntersPasswordValue();
        return new CommonPage(driver);
    }


    public LoginPage userEntersLoginName() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(LOGIN_INPUT));
        loginField.click();
        loginField.sendKeys(loginData);
        proceedButton.click();
        return this;
    }

    public CommonPage userEntersPasswordValue() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(PASSWORD_INPUT));
        passwordField.click();
        passwordField.sendKeys(passwordData);
        proceedButton.click();
        return new CommonPage(driver);
    }

    public boolean checkThatYouHaveLoggedOff() {
        return passwordField.isDisplayed();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(PROCEED_BUTTON));
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {

    }
}
