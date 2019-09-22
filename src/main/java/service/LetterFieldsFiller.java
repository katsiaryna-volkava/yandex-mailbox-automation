package service;

import models.Letter;

public class LetterFieldsFiller {

    private LetterFieldsFiller() {
    }

    private static final String TESTDATA_MAIL_RECIPIENT_VALUE = "testdata.letter.recipient";
    private static final String TESTDATA_MAIL_SUBJECT_VALUE = "testdata.letter.subject";
    private static final String TESTDATA_MAIL_BODY_VALUE = "testdata.letter.body";

    public static Letter withDataFromProperty() {
        return new Letter(TestDataReader.getTestData(TESTDATA_MAIL_RECIPIENT_VALUE),
                TestDataReader.getTestData(TESTDATA_MAIL_SUBJECT_VALUE),
                TestDataReader.getTestData(TESTDATA_MAIL_BODY_VALUE));
    }
}
