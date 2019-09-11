package pages.authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class HomePage extends BasePage {
    private static final String LOGIN_BUTTON_XPATH = "//a[contains(@class, 'Button-Enter with-shadow')]";

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage proceedToLoginPage() {
        loginButton.click();
        logger.info("Login page was opened");
        return new LoginPage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
    }
}
