package pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WaitUtils;

public class SentLetterTemplatePage extends BasePage {

    private static final String FORWARD_BUTTON = "//div[contains(@class,'ns-view-toolbar-button-forward')]";
    private static final String SENT_LETTER_SUBJECT = "//div[contains(@class,'mail-Message-Toolbar-Subject_message')]";

    @FindBy(xpath = FORWARD_BUTTON)
    private WebElement forwardButton;

    @FindBy(xpath = SENT_LETTER_SUBJECT)
    private WebElement letterSubject;

    public SentLetterTemplatePage(WebDriver driver) {
        super(driver);
    }

    public String getLetterSubject() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(SENT_LETTER_SUBJECT));
        return letterSubject.getText();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(FORWARD_BUTTON));
    }
}
