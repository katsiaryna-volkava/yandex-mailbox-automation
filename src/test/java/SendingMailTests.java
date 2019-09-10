import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;

import java.util.ArrayList;
import java.util.List;

public class SendingMailTests extends CommonConditions {

    private static final String EXPECTED_LETTER_SUBJECT = TestData.getMailSubjectValue();
    private final String EXPECTED_LETTER_BODY = TestData.getMailBodyValue();

    private final List<String> EXPECTED_LETTER_FIELDS;

    {
        EXPECTED_LETTER_FIELDS = new ArrayList<>();
        EXPECTED_LETTER_FIELDS.add(EXPECTED_LETTER_SUBJECT);
        EXPECTED_LETTER_FIELDS.add(EXPECTED_LETTER_BODY);
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
}
