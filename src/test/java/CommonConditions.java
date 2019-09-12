import driver.DriverSingleton;
import models.Letter;
import models.Mailbox;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import service.LetterFieldsFiller;
import service.MailboxCreator;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected Mailbox testMailbox = MailboxCreator.withCredentialsFromProperty();
    protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();

    private static final String LOGIN_PAGE_URL = "https://mail.yandex.by";

    @BeforeMethod
    public void browserSetup() {
        setUpDriver();
        maximazeBrowser();
        setUpTimeout(driver);
        goToLoginPage();
    }

    void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    void setUpDriver() {
        driver = DriverSingleton.getDriver();
    }

    void maximazeBrowser() {
        driver.manage().window().maximize();
    }

    public static void setUpTimeout(WebDriver driver) {
        int timeout = Integer.valueOf(System.getProperty("Timeout"));
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void browserClose() {
        DriverSingleton.closeDriver();
    }
}
