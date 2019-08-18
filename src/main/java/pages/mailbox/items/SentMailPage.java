package pages.mailbox.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.letters.templates.SentLetterTemplatePage;
import utils.WaitUtils;

public class SentMailPage extends BasePage {

    private static final String SENT_LETTER = "//div[@class='mail-MessageSnippet-Content']";

    @FindBy(xpath = SENT_LETTER)
    private WebElement sentLetter;

    public SentMailPage(WebDriver driver) {
        super(driver);
    }

    public SentLetterTemplatePage openSentLetter() {
        waitForPageToBeLoaded();
        sentLetter.click();
        return new SentLetterTemplatePage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(SENT_LETTER));
    }
}
