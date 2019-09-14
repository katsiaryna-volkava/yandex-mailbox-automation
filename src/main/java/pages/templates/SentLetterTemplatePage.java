package pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.*;

public class SentLetterTemplatePage extends BasePage {

    private static final String FORWARD_BUTTON = "//div[contains(@class,'ns-view-toolbar-button-forward')]";
    private static final String SENT_LETTER_SUBJECT = "//div[contains(@class,'mail-Message-Toolbar-Subject_message')]";

    public String getLetterSubject() {
        $(By.xpath(SENT_LETTER_SUBJECT)).waitUntil(appears, 10000);
        return $(By.xpath(SENT_LETTER_SUBJECT)).getText();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        $(By.xpath(FORWARD_BUTTON)).waitUntil(appears, 10000);
    }
}
