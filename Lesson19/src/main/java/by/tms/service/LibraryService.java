package by.tms.service;

import by.tms.model.Book;
import by.tms.model.EmailAddress;
import by.tms.model.Library;
import by.tms.model.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static by.tms.utils.Constants.NUMBER_OF_BOOKS_TAKEN;

@AllArgsConstructor
@ToString
@Getter
public class LibraryService implements LibraryServiceAware {
    private Library library;

    @Override
    public List<Book> getBookByYear() {
        return library.books().stream()
                .sorted(Comparator.comparing(Book::getYear))
                .toList();
    }

    @Override
    public List<Book> getTakenBook() {
        Set<Book> takenBooks = library.readers().stream()
                .flatMap(reader -> reader.takenBooks().stream())
                .collect(Collectors.toSet());
        return takenBooks.stream()
                .toList();
    }

    @Override
    public List<Reader> getReadersWhoTakenBookByAuthor(String author) {
        Map<Reader, List<Book>> readerBookMap = library.readers().stream()
                .collect(Collectors.toMap(Function.identity(), Reader::takenBooks));
        List<Reader> readers = new ArrayList<>();
        for (Map.Entry<Reader, List<Book>> item : readerBookMap.entrySet()) {
            Optional<Book> anyBook = item.getValue().stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .findAny();
            if (anyBook.isPresent()) {
                readers.add(item.getKey());
            }
        }
        return readers;
    }

    @Override
    public List<EmailAddress> getAllEmail() {
        return library.readers().stream()
                .map(Reader::email)
                .toList();
    }

    @Override
    public List<EmailAddress> getConcertedEmail() {
        return library.readers().stream()
                .filter(reader -> reader.takenBooks().size() > NUMBER_OF_BOOKS_TAKEN)
                .filter(Reader::mailingConsent)
                .map(Reader::email)
                .toList();
    }

    @Override
    public boolean setBookToReader(long readerId, long bookId) {
        Optional<Book> neededBook = library.books().stream()
                .filter(book -> book.getId() == bookId)
                .findAny();
        if (neededBook.isPresent()) {
            Optional<Boolean> bookToReader = library.readers().stream()
                    .filter(reader -> reader.id() == readerId)
                    .map(reader -> reader.takenBooks().add(neededBook.get()))
                    .findAny();
            if (bookToReader.isPresent()) {
                return bookToReader.get();
            }
        }
        return false;
    }
}