package by.tms.model;

import java.util.ArrayList;
import java.util.List;

public record Reader(long id, String fullName, EmailAddress email, boolean mailingConsent, List<Book> takenBooks) {
    public Reader {
        if (takenBooks == null) {
            takenBooks = new ArrayList<>();
        }
    }
}