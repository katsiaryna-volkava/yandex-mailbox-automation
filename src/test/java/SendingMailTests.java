import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;

import java.util.List;

public class SendingMailTests extends CommonConditions {

    @Test(priority = 2)
    public void userCanFindUnsavedLetterInDraftsFolder() {
        List<String> actualDraftLetterFields = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials(testMailbox)
                .openTemplateForWritingNewLetter()
                .fillInLetterFields(testLetter)
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, testLetter.getLetterSubjectAndBody());
    }

    @Test(priority = 3)
    public void userCanSendTheLetterSavedAsDraft() {
        String actualSentLetterSubject = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials(testMailbox)
                .openTemplateForWritingNewLetter()
                .fillInLetterFields(testLetter)
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .sendLetter()
                .goToSentMailFolder()
                .openSentLetter()
                .getLetterSubject();
        Assert.assertEquals(actualSentLetterSubject, testLetter.getMailSubject());
    }
}
