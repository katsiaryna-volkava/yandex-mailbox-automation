import org.testng.annotations.Test;
import pages.authorization.HomePage;

public class SendingMailTests extends CommonConditions {

    @Test(priority = 2)
    public void userCanFindUnsavedLetterInDraftsFolder() {
        new HomePage().proceedToLoginPage()
                .enterCredentials(testMailbox)
                .openTemplateForWritingNewLetter()
                .fillInLetterFields(testLetter)
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .checkThatLetterAttributesAreCorrect();
    }

    @Test(priority = 3)
    public void userCanSendTheLetterSavedAsDraft() {
        new HomePage().proceedToLoginPage()
                .enterCredentials(testMailbox)
                .openTemplateForWritingNewLetter()
                .fillInLetterFields(testLetter)
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .sendLetter()
                .goToSentMailFolder()
                .openSentLetter()
                .checkThatSubjectIsCorrect();
    }
}
