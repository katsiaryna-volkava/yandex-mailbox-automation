package service;

import models.Mailbox;

public class MailboxCreator {

    private MailboxCreator() {
    }

    public static final String TESTDATA_MAILBOX_NAME = "testdata.mailbox.name";
    public static final String TESTDATA_MAILBOX_PASSWORD = "testdata.mailbox.password";

    public static Mailbox withCredentialsFromProperty(){
        return new Mailbox(TestDataReader.getTestData(TESTDATA_MAILBOX_NAME),
                TestDataReader.getTestData(TESTDATA_MAILBOX_PASSWORD));
    }
}