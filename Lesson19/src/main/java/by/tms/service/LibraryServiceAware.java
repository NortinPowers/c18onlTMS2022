package by.tms.service;

import by.tms.model.Book;
import by.tms.model.EmailAddress;
import by.tms.model.Reader;
import by.tms.utils.Group;

import java.util.List;
import java.util.Map;

public interface LibraryServiceAware {
    List<Book> getBookByYear();

    List<Book> getTakenBook();

    List<Reader> getReadersWhoTakenBookByAuthor(String author);

    List<EmailAddress> getAllEmail();

    List<String> getConcertedEmail();

    boolean setBookToReader(long readerId, long bookId);

    String getMaxCountOfBookByReaders();

    Map<Enum<Group>, List<EmailAddress>> getDependedEmailByBooksCount();

    Map<Enum<Group>, List<String>> getReaderFullNameByEmailGroup();

    String getReaderFullNameByEmailGroupWithFormatting();
}