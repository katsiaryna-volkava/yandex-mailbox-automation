import models.Letter;
import models.Mailbox;
import org.testng.annotations.*;
import service.LetterFieldsFiller;
import service.MailboxCreator;
import utils.TestListener;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners({TestListener.class})
public class CommonConditions {


    protected Mailbox testMailbox = MailboxCreator.withCredentialsFromProperty();
    protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();

    @BeforeMethod
    public void browserSetup() {
        browser = "chrome";
        startMaximized = true;
        timeout = 30000;
        baseUrl = "https://mail.yandex.by";
        reportsFolder = "target/screenshots";

        open(baseUrl);
    }

    @AfterMethod
    public void browserClose() {
        closeWebDriver();
    }
}
