import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SetUpAndTearDown {

    protected WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://mail.yandex.by";

    @BeforeMethod
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        maximazeBrowser();
        String timeout = System.getProperty("Timeout");
        waitImplicitly(driver, Integer.valueOf(timeout));
        goToLoginPage();
    }

    void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }


    void maximazeBrowser() {
        driver.manage().window().maximize();
    }

    public static void waitImplicitly(WebDriver driver, Integer seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void browserClose() {
        DriverSingleton.closeDriver();
    }
}
