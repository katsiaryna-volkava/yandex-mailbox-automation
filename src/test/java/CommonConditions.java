import com.codeborne.selenide.Configuration;
import models.Letter;
import models.Mailbox;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import service.LetterFieldsFiller;
import service.MailboxCreator;
import utils.TestListener;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

import java.util.concurrent.TimeUnit;

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

        open(baseUrl);
    }

    @AfterMethod
    public void browserClose() {
        closeWebDriver();
    }
}
