import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.logining.HomePage;

import java.util.ArrayList;
import java.util.List;

public class TestRunner extends SetUpAndTearDown {

    private static final String EXPECTED_LETTER_SUBJECT = "automation task";
    private final List<String> expectedLetterFields;

    {
        expectedLetterFields = new ArrayList<>();
        expectedLetterFields.add("automation task");
        expectedLetterFields.add("This is test task for webdriever module.");
    }

    @Test(priority = 1)
    public void userIsLoggedInIntoMailbox() {
        String actualMailboxName =  new HomePage(driver)
                .proceedToLoginPage()
                .userEntersLoginName()
                .userEntersPasswordValue()
                .findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, "cdp-automation2");
    }

    @Test(priority = 2)
    public void userCanFindUnsavedLetterInDraftsFolder() {
        new CommonOperations().loginToMailbox(driver);
        List<String> actualDraftLetterFields = new HomePage(driver)
                .proceedToLoginPage()
                .userEntersLoginName()
                .userEntersPasswordValue()
                .openTemplateForWritingNewLetter()
                .fillInLetterFields()
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, expectedLetterFields);
    }

    @Test(priority = 3)
    public void userCanSendTheLetterSavedAsDraft() throws InterruptedException {
        String actualSentLetterBody = new HomePage(driver)
                .proceedToLoginPage()
                .userEntersLoginName()
                .userEntersPasswordValue()
                .openTemplateForWritingNewLetter()
                .fillInLetterFields()
                .closeLetterWithoutSaving()
                .goToDraftsPage()
                .openDraftLetter()
                .sendLetter()
                .goToSentMailFolder()
                .openSentLetter()
                .checkThatMailBodyIsCorrect();
        Assert.assertEquals(actualSentLetterBody, EXPECTED_LETTER_SUBJECT);
    }

    @Test(priority = 4)
    public void userIsLoggedOffFromMailbox() {
        new CommonOperations().loginToMailbox(driver);
        boolean isButtonPresent = new HomePage(driver)
                .proceedToLoginPage()
                .userEntersLoginName()
                .userEntersPasswordValue()
                .exitFromCurrentMailbox()
                .checkThatYouHaveLoggedOff();
        Assert.assertTrue(isButtonPresent);
    }
}
