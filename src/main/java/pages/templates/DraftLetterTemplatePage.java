package pages.templates;

import models.Letter;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.CommonPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selenide.*;

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

    public DraftLetterTemplatePage fillInLetterFields(Letter letter) {
        fillInLetterSubject(letter.getMailSubject());
        fillInLetterRecipient(letter.getMailRecipint());
        fillInLetterBody(letter.getMailBody());
        //   logger.info("Letter fields were filled in");
        return this;
    }

    public CommonPage closeLetterWithoutSaving() {
        $(By.xpath(CLOSE_BUTTON)).click();
        $(By.xpath(CLOSE_CONFIRMATION_BUTTON)).click();
        return new CommonPage();
    }

    public CommonPage sendLetter() {
        $(By.xpath(SEND_LETTER_BUTTON)).click();

        try {
            $(By.xpath(CAPTCHA_POPUP)).waitUntil(disappears, 10000);
        } catch (Exception e) {
            //  logger.info("There is a captcha protection. Type it manually");
        }
        return new CommonPage();
    }

    public List<String> findLetterAttributes() {
        letterAttributes = new ArrayList<>();
        String actualSubjectValue = $(By.xpath(SUBJECT_FIELD)).getAttribute("value");
        letterAttributes.add(actualSubjectValue);
        String actualBodyValue = $(By.xpath(MAIL_BODY_FIELD)).getText();
        letterAttributes.add(actualBodyValue);
        return letterAttributes;
    }

    public void fillInLetterRecipient(String letterRecipient) {
        $(By.xpath(MAIL_RECIPIENT_FIELD)).click();
        $(By.xpath(MAIL_RECIPIENT_FIELD)).sendKeys(letterRecipient);
    }

    public void fillInLetterSubject(String letterSubject) {
        waitForPageToBeLoaded();
        $(By.xpath(SUBJECT_FIELD)).click();
        $(By.xpath(SUBJECT_FIELD)).sendKeys(letterSubject);
    }

    public void fillInLetterBody(String letterBody) {
        $(By.xpath(MAIL_BODY_FIELD)).click();
        $(By.xpath(MAIL_BODY_FIELD)).sendKeys(letterBody);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        $(By.xpath(CLOSE_BUTTON)).waitUntil(appears, 20000);
    }
}
