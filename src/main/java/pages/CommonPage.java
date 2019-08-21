package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.templates.DraftLetterTemplatePage;
import pages.authorization.LoginPage;
import pages.items.DraftsPage;
import pages.items.SentMailPage;
import utils.WaitUtils;

public class CommonPage extends BasePage {

    private static final String MAILBOX_INDICATION = "//div[@class='mail-User-Name']";
    private static final String WRITE_NEW_LETTER_BUTTON = "//span[@class='mail-ComposeButton-Text']";
    private static final String DRAFTS_FOLDER = "//div[@data-key='box=folders-box']/div/a[@data-params='fid=6']";
    private static final String SENT_MAIL_FOLDER = "//div[@data-key='box=folders-box']/div/a[@data-params='fid=4']";
    private static final String ACCOUNT_SETTINGS_DROPDOWN_OPTION = "//a[@data-metric='Account settings']";
    private static final String USER_ACCOUNT_BUTTON = "//a[contains(@class,'current-account')]";
    private static final String EXIT_BUTTON = "//a[contains(@class,'item_action_exit')]";


    @FindBy(xpath = MAILBOX_INDICATION)
    private WebElement mailboxIndication;

    @FindBy(xpath = ACCOUNT_SETTINGS_DROPDOWN_OPTION)
    private WebElement accountSettings;

    @FindBy(xpath = USER_ACCOUNT_BUTTON)
    private WebElement currentAccountButton;

    @FindBy(xpath = EXIT_BUTTON)
    private WebElement exitButton;

    @FindBy(xpath = WRITE_NEW_LETTER_BUTTON)
    private WebElement writeNewLetterButton;

    @FindBy(xpath = DRAFTS_FOLDER)
    private WebElement draftsFolder;

    @FindBy(xpath = SENT_MAIL_FOLDER)
    private WebElement sentMailFolder;


    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public String findTheNameOfMailboxYouAreLoggedInto() {
        String mailboxName = mailboxIndication.getText();
        return mailboxName;
    }

    public DraftLetterTemplatePage openTemplateForWritingNewLetter() {
        writeNewLetterButton.click();
        return new DraftLetterTemplatePage(driver);
    }

    public DraftsPage goToDraftsPage() {
        draftsFolder.click();
        return new DraftsPage(driver);
    }

    public SentMailPage goToSentMailFolder() {
        sentMailFolder.click();
        resfreshCurrentPage();
        return new SentMailPage(driver);
    }

    public LoginPage exitFromCurrentMailbox() {
        Actions action = new Actions(driver);
        waitForPageToBeLoaded();
        action.click(mailboxIndication).perform();
        waitForElementToBeLoaded(accountSettings);
        action.click(accountSettings).perform();
        waitForElementToBeLoaded(currentAccountButton);
        action.click(currentAccountButton).perform();
        waitForElementToBeLoaded(exitButton);
        action.click(exitButton).build().perform();

        return new LoginPage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(MAILBOX_INDICATION));
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {
        WaitUtils.waitUntilVisibilityOfElement(driver, element);
    }
}
