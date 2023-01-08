package by.tms.model;

import java.util.ArrayList;
import java.util.List;

public record Library(List<Book> books, List<Reader> readers) {
    public Library {
        if (books == null) {
            books = new ArrayList<>();
        }
        if (readers == null) {
            readers = new ArrayList<>();
        }
    }
}