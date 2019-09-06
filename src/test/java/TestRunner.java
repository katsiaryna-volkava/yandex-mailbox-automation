import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestRunner extends SetUpAndTearDown {

    private static final String EXPECTED_LETTER_SUBJECT = TestData.getMailSubjectValue();
    private final String EXPECTED_MAILBOX_NAME = TestData.getLoginNameValue();
    private final String EXPECTED_LETTER_BODY = TestData.getMailBodyValue();

    private final List<String> EXPECTED_LETTER_FIELDS;

    {
        EXPECTED_LETTER_FIELDS = new ArrayList<>();
        EXPECTED_LETTER_FIELDS.add(EXPECTED_LETTER_SUBJECT);
        EXPECTED_LETTER_FIELDS.add(EXPECTED_LETTER_BODY);
    }

    public TestRunner() {
    }

    @Test(priority = 1)
    public void userIsLoggedInIntoMailbox() {
        String actualMailboxName = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials()
                .findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, EXPECTED_MAILBOX_NAME);
    }

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
        Assert.assertEquals(actualDraftLetterFields, EXPECTED_LETTER_FIELDS);
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
        Assert.assertEquals(actualSentLetterBody, EXPECTED_LETTER_SUBJECT);
    }

    @Test(priority = 4)
    public void userIsLoggedOffFromMailbox() {
        boolean isButtonPresent = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials()
                .exitFromCurrentMailbox()
                .checkThatYouHaveLoggedOff();
        Assert.assertTrue(isButtonPresent);
    }
}
