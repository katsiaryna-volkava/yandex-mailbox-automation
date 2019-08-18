package pages.letters.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class DraftLetterTemplatePage extends BasePage {

    List<String> letterAttributes;

    private static final String MAIL_RECIPIENT_FIELD = "//div[@class='mail-Compose-Field-Input']/div[@name='to']";
    private static final String SUBJECT_FIELD = "//div[@class='mail-Compose-Field-Input']/input[contains(@name, 'subj')]";
    private static final String CLOSE_BUTTON = "//div[contains(@data-key, 'view=compose-cancel-button')]";
    private static final String CLOSE_CONFIRMATION_BUTTON = "//div[@class='_nb-popup-buttons']/button[@data-action='save']";
    private static final String MAIL_BODY_FIELD = "//div[@role='textbox']";
    private static final String SEND_LETTER_BUTTON = "//button[contains(@class, '_init js-send-button')]";

    private static final String MAIL_RECIPIENT_VALUE = "katsiaryna_volkava@gmail.com";
    private static final String MAIL_SUBJECT_VALUE = "automation task";
    private static final String MAIL_BODY_VALUE = "This is test task for webdriever module.";


    @FindBy(xpath = MAIL_RECIPIENT_FIELD)
    private WebElement mailRecipientField;

    @FindBy(xpath = SUBJECT_FIELD)
    private WebElement subjectField;

    @FindBy(xpath = MAIL_BODY_FIELD)
    private WebElement mailBodyField;

    @FindBy(xpath = CLOSE_BUTTON)
    private WebElement closeButton;

    @FindBy(xpath = CLOSE_CONFIRMATION_BUTTON)
    private WebElement closeConfirmButton;

    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    public DraftLetterTemplatePage(WebDriver driver) {
        super(driver);
    }

    public DraftLetterTemplatePage fillInLetterFields() {
        fillInLetterSubject();
        fillInLetterRecipient();
        fillInLetterBody();
        return this;
    }

    public CommonPage closeLetterWithoutSaving() {
        closeButton.click();
        closeConfirmButton.click();
        return new CommonPage(driver);
    }

    public CommonPage sendLetter() {
        sendLetterButton.click();
        return new CommonPage(driver);
    }

    public List<String> findLetterAttributes() {
        letterAttributes = new ArrayList<>();
        String actualSubjectValue = subjectField.getAttribute("value");
        letterAttributes.add(actualSubjectValue);

        String actualBodyValue = mailBodyField.getText();
        letterAttributes.add(actualBodyValue);
        return letterAttributes;
    }

    public void fillInLetterRecipient() {
        mailRecipientField.click();
        mailRecipientField.sendKeys(MAIL_RECIPIENT_VALUE);
    }

    public void fillInLetterSubject() {
        waitForPageToBeLoaded();
        subjectField.click();
        subjectField.sendKeys(MAIL_SUBJECT_VALUE);
    }

    public void fillInLetterBody() {
        mailBodyField.click();
        mailBodyField.sendKeys(MAIL_BODY_VALUE);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(CLOSE_BUTTON));
    }
}
