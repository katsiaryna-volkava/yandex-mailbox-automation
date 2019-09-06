import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class SetUpAndTearDown {

    protected WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://mail.yandex.by";
    private static final String GOOGLE_CHROME_DRIVER_PATH = ".//src/main/resources/chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    @BeforeMethod
    public void browserSetup() throws IOException {
        prepareChromeBrowser();
        setTheGeneralTimeoutFromConsole(driver);
        maximazeBrowser();
        goToLoginPage();
    }

    void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    void prepareChromeBrowser() {
        System.setProperty(CHROME_DRIVER_PROPERTY, GOOGLE_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    public static void setTheGeneralTimeoutFromConsole(WebDriver driver) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int seconds = Integer.parseInt(reader.readLine());
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    void maximazeBrowser() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void browserClose() {
        driver.quit();
    }
}
