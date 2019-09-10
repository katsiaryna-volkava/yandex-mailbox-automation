import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;

public class AuthorizationTests extends CommonConditions {

    private final String EXPECTED_MAILBOX_NAME = TestData.getLoginNameValue();

    @Test(priority = 1)
    public void userIsLoggedInIntoMailbox() {
        String actualMailboxName = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials()
                .findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, EXPECTED_MAILBOX_NAME);
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
