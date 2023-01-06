package by.tms.service;

import by.tms.model.Book;
import by.tms.model.EmailAddress;
import by.tms.model.Reader;

import java.util.List;

public interface LibraryServiceAware {
    List<Book> getBookByYear();

    List<Book> getTakenBook();

    List<Reader> getReadersWhoTakenBookByAuthor(String author);

    List<EmailAddress> getAllEmail();

    List<EmailAddress> getConcertedEmail();

    boolean setBookToReader(long readerId, long bookId);
}