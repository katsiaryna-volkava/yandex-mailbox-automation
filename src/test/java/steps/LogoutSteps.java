package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CommonPage;
import pages.authorization.LoginPage;


public class LogoutSteps {

    LoginPage loginPage;


    @When("^I logout from current account$")
    public void exitFromCurrentAccount() {
        loginPage = new CommonPage().exitFromCurrentMailbox();
    }


    @Then("^I'm on a login page$")
    public void checkYouHaveLoggedOff() {
        boolean isButtonPresent = loginPage.checkThatYouHaveLoggedOff();
        Assert.assertTrue(isButtonPresent);
    }
}
