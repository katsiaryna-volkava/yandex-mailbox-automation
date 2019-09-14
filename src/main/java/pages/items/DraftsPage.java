package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.templates.DraftLetterTemplatePage;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.$;

public class DraftsPage extends BasePage {

    private static final String DRAFT_LETTER = "//div[@class='mail-MessageSnippet-Content']";

    public DraftLetterTemplatePage openDraftLetter() {
        waitForPageToBeLoaded();
        $(By.xpath(DRAFT_LETTER)).click();
        logger.info("Draft letter was opened");
        return new DraftLetterTemplatePage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        $(By.xpath(DRAFT_LETTER)).waitUntil(appears, 20000);
    }
}
