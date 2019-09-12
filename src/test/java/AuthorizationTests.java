import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;

public class AuthorizationTests extends CommonConditions {

    @Test(testName = "Login to mailbox", priority = 1)
    public void userIsLoggedInIntoMailbox() {
        String actualMailboxName = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials(testMailbox)
                .findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, testMailbox.getMailboxName());
    }

    @Test(priority = 4)
    public void userIsLoggedOffFromMailbox() {
        boolean isButtonPresent = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials(testMailbox)
                .exitFromCurrentMailbox()
                .checkThatYouHaveLoggedOff();
        Assert.assertTrue(isButtonPresent);
    }
}