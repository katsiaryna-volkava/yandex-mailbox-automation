package pages.authorization;

import models.Mailbox;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.CommonPage;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private static final String LOGIN_INPUT = "//input[@type='text' and @name='login']";
    private static final String PASSWORD_INPUT = "//div[@class='passp-password-field']//input[@type='password' and @name='passwd']";
    private static final String PROCEED_BUTTON = "//button[@type='submit']";

    public CommonPage enterCredentials(Mailbox mailbox) {
        userEntersLoginName(mailbox.getMailboxName());
        userEntersPasswordValue(mailbox.getMailboxPassword());
        logger.info("Login was performed");

        return new CommonPage();
    }

    public LoginPage userEntersLoginName(String mailboxName) {
        $(By.xpath(LOGIN_INPUT)).sendKeys(mailboxName);
        $(By.xpath(PROCEED_BUTTON)).click();
        return this;
    }

    public CommonPage userEntersPasswordValue(String mailboxPassword) {
        $(By.xpath(PASSWORD_INPUT)).sendKeys(mailboxPassword);
        $(By.xpath(PROCEED_BUTTON)).click();
        return new CommonPage();
    }

    public void checkThatYouHaveLoggedOff() {
        $(By.xpath(PASSWORD_INPUT)).shouldBe(visible);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        $(By.xpath(PROCEED_BUTTON)).waitUntil(appears, 20000);
    }
}
