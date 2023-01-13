package by.tms.service;

import by.tms.model.Book;
import by.tms.model.EmailAddress;
import by.tms.model.Reader;
import by.tms.utils.Group;

import java.util.List;
import java.util.Map;

public interface LibraryServiceAware {
    List<Book> getBooksSortedByYear();

    List<Book> getTakenBooks();

    List<Reader> getReadersWhoTakenBookByAuthor(String author);

    List<EmailAddress> getAllEmails();

    List<String> getConcertedEmails();

    void setBookToReader(long readerId, long bookId);

    String getMaxCountOfBookByReaders();

    Map<Enum<Group>, List<EmailAddress>> getDependedEmailsByBooksCount();

    Map<Enum<Group>, List<String>> getReadersFullNamesByEmailsGroups();

    String getReaderFullNameByEmailGroupWithFormatting();
}