import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class SetUpAndTearDown {

    protected WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://mail.yandex.by";
    private static final String GOOGLE_CHROME_DRIVER_PATH = ".//src/main/resources/chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    @BeforeMethod
    public void browserSetup() {
        prepareChromeBrowser();
        maximazeBrowser();
        String timeout = System.getProperty("Timeout");
        waitImplicitly(driver, Integer.valueOf(timeout));
        goToLoginPage();
        System.out.println(timeout + "- timeout");
    }

    void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    void prepareChromeBrowser() {
        System.setProperty(CHROME_DRIVER_PROPERTY, GOOGLE_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    void maximazeBrowser() {
        driver.manage().window().maximize();
    }

    public static void waitImplicitly(WebDriver driver, Integer seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void browserClose() {
        driver.quit();
    }
}
