package pages.items;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.templates.SentLetterTemplatePage;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class SentMailPage extends BasePage {

    private static final String SENT_LETTER = "//div[@class='mail-MessageSnippet-Content']";

    public SentLetterTemplatePage openSentLetter() {
        refresh();
        waitForPageToBeLoaded();
        $(By.xpath(SENT_LETTER));
        logger.info("Letter was sent");
        return new SentLetterTemplatePage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        $(By.xpath(SENT_LETTER)).waitUntil(appears, 20000);
    }
}
