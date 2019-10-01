package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import models.Mailbox;
import org.testng.Assert;
import pages.CommonPage;
import pages.authorization.HomePage;
import service.MailboxCreator;

public class LoginSteps {

    protected Mailbox testMailbox = MailboxCreator.withCredentialsFromProperty();


    @When("^I do login into my mailbox account$")
    public void loginToMailbox() {
        new HomePage().proceedToLoginPage().enterCredentials(testMailbox);
    }


    @Then("^I'm logged into it$")
    public void checkUserIsLoggedIntoCorrectMailbox() {
        String actualMailboxName = new CommonPage().findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, testMailbox.getMailboxName());
    }


    @Given("^User is logged in into mailbox account$")
    public CommonPage userIsLoggedIn() {
        return new HomePage().proceedToLoginPage().enterCredentials(testMailbox);
    }
}
