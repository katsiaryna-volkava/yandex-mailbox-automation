import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import pages.letters.templates.DraftLetterTemplatePage;
import pages.logining.HomePage;

public class CommonOperations {

    public CommonPage loginToMailbox(WebDriver driver) {
        new HomePage(driver)
                .proceedToLoginPage()
                .userEntersLoginName()
                .userEntersPasswordValue();
        return new CommonPage(driver);
    }

    public DraftLetterTemplatePage createDraftMail(WebDriver driver) {
        new CommonPage(driver)
                .openTemplateForWritingNewLetter()
                .fillInLetterFields()
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter();
        return new DraftLetterTemplatePage(driver);
    }

    public CommonPage sendLetterFromDraft(WebDriver driver) {
        new DraftLetterTemplatePage(driver)
                .sendLetter();
        return new CommonPage(driver);
    }
}
