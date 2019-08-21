package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.templates.DraftLetterTemplatePage;
import utils.WaitUtils;

public class DraftsPage extends BasePage {

    private static final String DRAFT_LETTER = "//div[@class='mail-MessageSnippet-Content']";

    @FindBy(xpath = DRAFT_LETTER)
    private WebElement draftLetter;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public DraftLetterTemplatePage openDraftLetter() {
        waitForPageToBeLoaded();
        new Actions(driver).click(draftLetter).build().perform();
        return new DraftLetterTemplatePage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(DRAFT_LETTER));
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {

    }
}
