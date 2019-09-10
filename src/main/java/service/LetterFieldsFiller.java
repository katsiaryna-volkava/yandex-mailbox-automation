package service;

import models.Letter;

public class LetterFieldsFiller {

    private static final String MAIL_RECIPIENT_VALUE = "katsiaryna_volkava@gmail.com";
    private static final String MAIL_SUBJECT_VALUE = "automation task";
    private static final String MAIL_BODY_VALUE = "This is test task for webdriever module.";

    public static Letter withDataFromProperty() {
        return new Letter(MAIL_RECIPIENT_VALUE, MAIL_SUBJECT_VALUE, MAIL_BODY_VALUE);
    }
}
