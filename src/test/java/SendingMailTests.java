import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;
import service.LetterFieldsFiller;

import java.util.List;

public class SendingMailTests extends CommonConditions {

    @Test(priority = 2)
    public void userCanFindUnsavedLetterInDraftsFolder() {
        List<String> actualDraftLetterFields = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials()
                .openTemplateForWritingNewLetter()
                .fillInLetterFields()
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, LetterFieldsFiller.withDataFromProperty().getLetterSubjectAndBody());
    }

    @Test(priority = 3)
    public void userCanSendTheLetterSavedAsDraft() {
        String actualSentLetterBody = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials()
                .openTemplateForWritingNewLetter()
                .fillInLetterFields()
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .sendLetter()
                .goToSentMailFolder()
                .openSentLetter()
                .getLetterSubject();
        Assert.assertEquals(actualSentLetterBody, LetterFieldsFiller.withDataFromProperty().getMailBody());
    }
}