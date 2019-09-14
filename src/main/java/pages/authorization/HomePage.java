package pages.authorization;

import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    private static final String LOGIN_BUTTON_XPATH = "//a[contains(@class, 'Button-Enter with-shadow')]";

    public LoginPage proceedToLoginPage() {
        $(By.xpath(LOGIN_BUTTON_XPATH)).click();
        return new LoginPage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
    }
}
