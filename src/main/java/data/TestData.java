package data;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TestData {
    private static final String LOGIN_NAME_VALUE = "cdp-automation2";
    private static final String PASSWORD_VALUE = "qwerty1234";

    private static final String MAIL_RECIPIENT_VALUE = "katsiaryna_volkava@gmail.com";
    private static final String MAIL_SUBJECT_VALUE = "automation task";
    private static final String MAIL_BODY_VALUE = "This is test task for webdriever module.";


    public static String getLoginNameValue() {
        return LOGIN_NAME_VALUE;
    }

    public static String getPasswordValue() {
        return PASSWORD_VALUE;
    }

    public static String getMailRecipientValue() {
        return MAIL_RECIPIENT_VALUE;
    }

    public static String getMailSubjectValue() {
        return MAIL_SUBJECT_VALUE;
    }

    public static String getMailBodyValue() {
        return MAIL_BODY_VALUE;
    }
}
