package models;

import service.LetterFieldsFiller;

import java.util.ArrayList;
import java.util.Objects;

public class Letter {

    private String mailRecipint;
    private String mailSubject;
    private String mailBody;

    public Letter(String mailRecipint, String mailSubject, String mailBody) {
        this.mailRecipint = mailRecipint;
        this.mailSubject = mailSubject;
        this.mailBody = mailBody;
    }

    public String getMailRecipint() {
        return mailRecipint;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public String getMailBody() {
        return mailBody;
    }

    public ArrayList<String> getLetterSubjectAndBody() {
        ArrayList<String> letterAttributes = new ArrayList<>();
        letterAttributes.add(LetterFieldsFiller.withDataFromProperty().getMailSubject());
        letterAttributes.add(LetterFieldsFiller.withDataFromProperty().getMailBody());
        return letterAttributes;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return getMailRecipint().equals(letter.getMailRecipint()) &&
                getMailSubject().equals(letter.getMailSubject()) &&
                getMailBody().equals(letter.getMailBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMailRecipint(), getMailSubject(), getMailBody());
    }
}
