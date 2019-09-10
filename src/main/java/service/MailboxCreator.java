package service;

import models.Mailbox;

public class MailboxCreator {

    public static final String MAILBOX_NAME = "cdp-automation2";
    public static final String MAILBOX_PASSWORD = "qwerty1234";

    public static Mailbox withCredentialsFromProperty(){
        return new Mailbox(MAILBOX_NAME, MAILBOX_PASSWORD);
    }
}