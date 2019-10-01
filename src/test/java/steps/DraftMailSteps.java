package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Letter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CommonPage;
import pages.templates.DraftLetterTemplatePage;
import service.LetterFieldsFiller;

import java.util.ArrayList;
import java.util.List;

public class DraftMailSteps {

    protected WebDriver driver;
    protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();

    DraftLetterTemplatePage draftLetterTemplate;
    CommonPage commonPage;

    @When("^I create a letter$")
    public void userFillsInLetterTemplate() {
        draftLetterTemplate = new CommonPage()
                .openTemplateForWritingNewLetter()
                .fillInLetterFields(testLetter);
    }


    @When("^I create a letter with ([^\"]*) to ([^\"]*) with ([^\"]*)$")
    public void userFillsInLetterTemplateWithTestData(String subject, String recipient, String body) {
        draftLetterTemplate = new CommonPage()
                .openTemplateForWritingNewLetter()
                .fillInLetterWithDataFromTest(subject, recipient, body);
    }


    @And("^I close letter without saving it$")
    public void userClosesLetterWithoutSaving() {
        commonPage = draftLetterTemplate.closeLetterWithoutSaving();
    }


    @Then("^I find this letter in a draft folder$")
    public void userChecksThatLetterIsSavedAsDraft() {
        List<String> actualDraftLetterFields =
                commonPage.goToDraftsPage()
                .openDraftLetter()
                .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, testLetter.getLetterSubjectAndBody());
    }


    @Then("^I find this letter in a draft folder with ([^\"]*) and ([^\"]*) attributes$")
    public void userChecksThatLetterIsSavedAsDraftWithTheFollowingAttributes(String subject, String body) {
        List<String> expectedDraftLetterFields = new ArrayList<>();
        expectedDraftLetterFields.add(subject);
        expectedDraftLetterFields.add(body);

        List<String> actualDraftLetterFields =
                commonPage.goToDraftsPage()
                        .openDraftLetter()
                        .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, expectedDraftLetterFields);
    }


    @And("^A draft letter is created$")
    public void userCreatesDraft() {
        new CommonPage()
                .openTemplateForWritingNewLetter()
                .fillInLetterFields(testLetter)
                .closeLetterWithoutSaving();
    }

}
