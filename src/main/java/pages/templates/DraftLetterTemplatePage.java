package pages.templates;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    private static final String CAPTCHA_POPUP = "//div[@class='b-popup__p']]";
    private static final String CAPTCHA_INPUT_FIELD = "//input[contains(@class,'s-captcha-input')]";

    private String mailSubject = TestData.getMailSubjectValue();
    private String mailRecipient = TestData.getMailRecipientValue();
    private String mailBody = TestData.getMailBodyValue();

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
        try {
            WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(CAPTCHA_POPUP));
            new Actions(driver).click(captchaInput).pause(25000).build().perform();
        } catch (Exception e) {
            System.out.println("There is a captcha protection");
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

    public void fillInLetterRecipient() {
        mailRecipientField.click();
        mailRecipientField.sendKeys(mailRecipient);
    }

    public void fillInLetterSubject() {
        waitForPageToBeLoaded();
        subjectField.click();
        subjectField.sendKeys(mailSubject);
    }

    public void fillInLetterBody() {
        mailBodyField.click();
        mailBodyField.sendKeys(mailBody);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(CLOSE_BUTTON));
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {

    }
}
