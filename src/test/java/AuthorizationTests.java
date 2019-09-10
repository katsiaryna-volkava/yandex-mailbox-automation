import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;
import service.MailboxCreator;

public class AuthorizationTests extends CommonConditions {

    @Test(priority = 1)
    public void userIsLoggedInIntoMailbox() {
        String actualMailboxName = new HomePage(driver)
                .proceedToLoginPage()
                .enterCredentials()
                .findTheNameOfMailboxYouAreLoggedInto();
        Assert.assertEquals(actualMailboxName, MailboxCreator.withCredentialsFromProperty().getMailboxName());
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
