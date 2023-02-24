package by.tms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Reader {

    private final long id;
    private final String fullName;
    private final EmailAddress email;
    @Setter
    private boolean mailingConsent;
    private final List<Book> takenBooks;

    public Reader(long id, String fullName, EmailAddress email, boolean mailingConsent, List<Book> takenBooks) {
        if (takenBooks == null) {
            takenBooks = new ArrayList<>();
        }
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.mailingConsent = mailingConsent;
        this.takenBooks = takenBooks;
    }
}