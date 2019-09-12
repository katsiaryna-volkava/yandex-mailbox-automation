package pages.templates;

import models.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import service.LetterFieldsFiller;
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
    private static final String CAPTCHA_POPUP = "//div[@class='b-popup__p']]";
    private static final String CAPTCHA_INPUT_FIELD = "//input[contains(@class,'s-captcha-input')]";

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

    @FindBy(xpath = CAPTCHA_POPUP)
    private WebElement captchaPopup;

    @FindBy(xpath = CAPTCHA_INPUT_FIELD)
    private WebElement captchaInput;

    public DraftLetterTemplatePage(WebDriver driver) {
        super(driver);
    }

    public DraftLetterTemplatePage fillInLetterFields(Letter letter) {
        fillInLetterSubject(letter.getMailSubject());
        fillInLetterRecipient(letter.getMailRecipint());
        fillInLetterBody(letter.getMailBody());
        logger.info("Letter fields were filled in");
        return this;
    }

    public CommonPage closeLetterWithoutSaving() {
        closeButton.click();
        closeConfirmButton.click();
        return new CommonPage(driver);
    }

    public CommonPage sendLetter() {
        sendLetterButton.click();
        try {
            WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(CAPTCHA_POPUP));
            new Actions(driver).click(captchaInput).pause(25000).build().perform();
        } catch (Exception e) {
            logger.info("There is a captcha protection. Type it manually");
        }
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

    public void fillInLetterRecipient(String letterRecipient) {
        mailRecipientField.click();
        mailRecipientField.sendKeys(letterRecipient);
    }

    public void fillInLetterSubject(String letterSubject) {
        waitForPageToBeLoaded();
        subjectField.click();
        subjectField.sendKeys(letterSubject);
    }

    public void fillInLetterBody(String letterBody) {
        mailBodyField.click();
        mailBodyField.sendKeys(letterBody);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(CLOSE_BUTTON));
    }
}
