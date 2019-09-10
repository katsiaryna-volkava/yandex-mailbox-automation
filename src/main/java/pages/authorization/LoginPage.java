package pages.authorization;

import models.Mailbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import service.MailboxCreator;
import utils.ElementActionsUtils;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    private static final String LOGIN_INPUT = "//input[@type='text' and @name='login']";
    private static final String PASSWORD_INPUT = "//div[@class='passp-password-field']//input[@type='password' and @name='passwd']";
    private static final String PROCEED_BUTTON = "//button[@type='submit']";

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
        Mailbox mailbox = MailboxCreator.withCredentialsFromProperty();
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(LOGIN_INPUT));
        ElementActionsUtils.highlightElement(driver, By.xpath(LOGIN_INPUT));
        ElementActionsUtils.clickOnElementAndTypeData(driver, loginField, mailbox.getMailboxName());
        ElementActionsUtils.clickElementJs(driver, proceedButton);
        return this;
    }

    public CommonPage userEntersPasswordValue() {
        Mailbox mailbox = MailboxCreator.withCredentialsFromProperty();
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(PASSWORD_INPUT));
        ElementActionsUtils.highlightElement(driver, By.xpath(PASSWORD_INPUT));
        ElementActionsUtils.clickOnElementAndTypeData(driver, passwordField, mailbox.getMailboxPassword());
        ElementActionsUtils.clickElementJs(driver, proceedButton);
        return new CommonPage(driver);
    }

    public boolean checkThatYouHaveLoggedOff() {
        return passwordField.isDisplayed();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(PROCEED_BUTTON));
    }
}
