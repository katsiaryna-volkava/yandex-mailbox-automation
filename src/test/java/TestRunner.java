import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;

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
        String actualMailboxName = loginToMailbox()
                .findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, "cdp-automation");
    }

    @Test(priority = 2)
    public void userCanFindUnsavedLetterInDraftsFolder() {
        loginToMailbox();
        List<String> actualDraftLetterFields = createDraftMail()
                .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, expectedLetterFields);
    }

    @Test(priority = 3)
    public void userCanSendTheLetterSavedAsDraft() throws InterruptedException {
        loginToMailbox();
        createDraftMail();
        String actualSentLetterBody = sendLetter()
                .goToSentMailFolder()
                .openSentLetter()
                .checkThatMailBodyIsCorrect();
        Assert.assertEquals(actualSentLetterBody, EXPECTED_LETTER_SUBJECT);
    }

    @Test(priority = 4)
    public void userIsLoggedOffFromMailbox() {
        loginToMailbox();
        boolean isButtonPresent = new CommonPage(driver)
                .exitFromCurrentMailbox()
                .checkThatYouHaveLoggedOff();
        Assert.assertTrue(isButtonPresent);
    }
}
