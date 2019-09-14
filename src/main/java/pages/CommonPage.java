package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.appears;

import org.openqa.selenium.By;
import pages.templates.DraftLetterTemplatePage;
import pages.authorization.LoginPage;
import pages.items.DraftsPage;
import pages.items.SentMailPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CommonPage extends BasePage {

    private static final String MAILBOX_INDICATION = "//div[@class='mail-User-Name']";
    private static final String WRITE_NEW_LETTER_BUTTON = "//span[@class='mail-ComposeButton-Text']";
    private static final String DRAFTS_FOLDER = "//div[@data-key='box=folders-box']/div/a[@data-params='fid=6']";
    private static final String SENT_MAIL_FOLDER = "//div[@data-key='box=folders-box']/div/a[@data-params='fid=4']";
    private static final String ACCOUNT_SETTINGS_DROPDOWN_OPTION = "//a[@data-metric='Account settings']";
    private static final String USER_ACCOUNT_BUTTON = "//a[contains(@class,'current-account')]";
    private static final String EXIT_BUTTON = "//a[contains(@class,'item_action_exit')]";


    public void checkTheLoginCorrectness() {
        $(By.xpath(MAILBOX_INDICATION))
                .shouldBe(visible)
                .shouldHave(text("cdp-automation2"));
    }

    public DraftLetterTemplatePage openTemplateForWritingNewLetter() {
        $(By.xpath(WRITE_NEW_LETTER_BUTTON)).click();
        return new DraftLetterTemplatePage();
    }

    public DraftsPage goToDraftsPage() {
        $(By.xpath(DRAFTS_FOLDER)).click();
        return new DraftsPage();
    }

    public SentMailPage goToSentMailFolder() {
        $(By.xpath(SENT_MAIL_FOLDER)).click();
        refresh();
        return new SentMailPage();
    }

    public LoginPage exitFromCurrentMailbox() {
        waitForPageToBeLoaded();
        $(By.xpath(MAILBOX_INDICATION)).click();
        $(By.xpath(ACCOUNT_SETTINGS_DROPDOWN_OPTION)).waitUntil(appears, 10000);
        $(By.xpath(ACCOUNT_SETTINGS_DROPDOWN_OPTION)).click();
        $(By.xpath(USER_ACCOUNT_BUTTON)).waitUntil(appears, 10000);
        $(By.xpath(USER_ACCOUNT_BUTTON)).click();
        $(By.xpath(EXIT_BUTTON)).waitUntil(appears, 10000);
        $(By.xpath(EXIT_BUTTON)).click();
        logger.info("Log out was performed");
        return new LoginPage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        $(By.xpath(MAILBOX_INDICATION)).waitUntil(Condition.appears, 10000);
    }
}
