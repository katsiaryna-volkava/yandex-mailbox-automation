import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.HomePage;

public class AuthorizationTests extends CommonConditions {

    @Test(testName = "Login to mailbox", priority = 1)
    public void userIsLoggedInIntoMailbox() {

        new HomePage().proceedToLoginPage()
                .enterCredentials(testMailbox)
                .checkTheLoginCorrectness();
    }

    @Test(priority = 4)
    public void userIsLoggedOffFromMailbox() {
       new HomePage().proceedToLoginPage()
               .enterCredentials(testMailbox)
               .exitFromCurrentMailbox()
               .checkThatYouHaveLoggedOff();
    }
}