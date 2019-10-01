package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Letter;
import org.testng.Assert;
import pages.CommonPage;
import pages.items.DraftsPage;
import pages.items.SentMailPage;
import service.LetterFieldsFiller;

public class SentMailSteps {

    protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();


    @When("^I send letter$")
    public CommonPage sendLetterFromDraft() {
        return new DraftsPage().openDraftLetter().sendLetter();
    }


    @Then("^I find it in a sent mail folder$")
    public void checkThatCorrectLetterIsSent() {
        String actualSentLetterSubject = new SentMailPage().openSentLetter().getLetterSubject();
        Assert.assertEquals(actualSentLetterSubject, testLetter.getMailSubject());
    }
}
