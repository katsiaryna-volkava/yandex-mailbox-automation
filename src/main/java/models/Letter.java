package models;

import service.LetterFieldsFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Letter {

    private String mailRecipient;
    private String mailSubject;
    private String mailBody;

    public Letter(String mailRecipient, String mailSubject, String mailBody) {
        this.mailRecipient = mailRecipient;
        this.mailSubject = mailSubject;
        this.mailBody = mailBody;
    }

    public String getMailRecipient() {
        return mailRecipient;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public String getMailBody() {
        return mailBody;
    }

    public List<String> getLetterSubjectAndBody() {
        List<String> letterAttributes = new ArrayList<>();
        letterAttributes.add(LetterFieldsFiller.withDataFromProperty().getMailSubject());
        letterAttributes.add(LetterFieldsFiller.withDataFromProperty().getMailBody());
        return letterAttributes;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return getMailRecipient().equals(letter.getMailRecipient()) &&
                getMailSubject().equals(letter.getMailSubject()) &&
                getMailBody().equals(letter.getMailBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMailRecipient(), getMailSubject(), getMailBody());
    }
}
