package models;

import java.util.Objects;

public class Mailbox {

    private String mailboxName;
    private String mailboxPassword;

    public Mailbox(String mailboxName, String password) {
        this.mailboxName = mailboxName;
        this.mailboxPassword = password;
    }

    public String getMailboxName() {
        return mailboxName;
    }

    public String getMailboxPassword() {
        return mailboxPassword;
    }

    @Override
    public String toString() {
        return "Mailbox{" +
                "mailboxName='" + mailboxName + '\'' +
                ", mailboxPassword='" + mailboxPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mailbox mailbox = (Mailbox) o;
        return Objects.equals(getMailboxName(), mailbox.getMailboxPassword()) &&
                Objects.equals(getMailboxPassword(), mailbox.getMailboxPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMailboxName(), getMailboxPassword());
    }
}
