package by.tms.service;

import by.tms.model.Book;
import by.tms.model.EmailAddress;
import by.tms.model.Library;
import by.tms.model.Reader;
import by.tms.utils.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static by.tms.utils.Constants.MAX_NUMBER_OF_BOOKS_TAKEN_TO_OK_LIST;
import static by.tms.utils.Constants.NUMBER_OF_BOOKS_TAKEN;
import static by.tms.utils.Group.OK;
import static by.tms.utils.Group.TOO_MUCH;

@AllArgsConstructor
@ToString
@Getter
public class LibraryService implements LibraryServiceAware {
    private Library library;

    /**
     * The method returns a list of books sorted by year of issue
     *
     * @return List
     */
    @Override
    public List<Book> getBooksSortedByYear() {
        return library.books().stream()
                .sorted(Comparator.comparing(Book::getYear))
                .toList();
    }

    /**
     * The method returns a list of books that readers currently have
     *
     * @return List
     */
    @Override
    public List<Book> getTakenBooks() {
        Set<Book> takenBooks = library.readers().stream()
                .flatMap(reader -> reader.takenBooks().stream())
                .collect(Collectors.toSet());
        return takenBooks.stream()
                .toList();
    }

    /**
     * The method returns a list of readers who have a book by a certain author
     *
     * @return List
     */
    @Override
    public List<Reader> getReadersWhoTakenBookByAuthor(String author) {
        Map<Reader, List<Book>> readerBookMap = library.readers().stream()
                .collect(Collectors.toMap(Function.identity(), Reader::takenBooks));
        List<Reader> readers = new ArrayList<>();
        for (Map.Entry<Reader, List<Book>> entry : readerBookMap.entrySet()) {
            Optional<Book> anyBook = entry.getValue().stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .findAny();
            if (anyBook.isPresent()) {
                readers.add(entry.getKey());
            }
        }
        return readers;
    }

    /**
     * The method returns a list of objects of the EmailAddress type
     *
     * @return List
     */
    @Override
    public List<EmailAddress> getAllEmails() {
        return library.readers().stream()
                .map(Reader::email)
                .toList();
    }

    /**
     * The method returns a list of objects of the EmailAddress type for readers who have more than 1 book
     *
     * @return List
     */
    @Override
    public List<String> getConcertedEmails() {
        return library.readers().stream()
                .filter(reader -> reader.takenBooks().size() > NUMBER_OF_BOOKS_TAKEN)
                .filter(Reader::mailingConsent)
                .map(Reader::email)
                .map(EmailAddress::getEmailAddress)
                .toList();
    }

    /**
     * The method assigns the book to the reader
     */
    @Override
    public void setBookToReader(long readerId, long bookId) {
        Optional<Book> neededBook = library.books().stream()
                .filter(book -> book.getId() == bookId)
                .findAny();
        neededBook.ifPresent(book -> library.readers().stream()
                .filter(reader -> reader.id() == readerId)
                .forEach(reader -> reader.takenBooks().add(book)));
    }

    /**
     * The method returns generate a string containing information about the maximum of books taken by readers
     *
     * @return String
     */
    @Override
    public String getMaxCountOfBookByReaders() {
        Map<Reader, Integer> readerCountBookMap = getReaderCountBookByReaderMap();
        Optional<Map.Entry<Reader, Integer>> optionalReaderIntegerEntry = readerCountBookMap.entrySet().stream().max(Map.Entry.comparingByValue());
        return optionalReaderIntegerEntry.map(readerIntegerEntry -> "The largest number of books in the hands of the reader: "
                + readerIntegerEntry.getValue() + ".").orElse(null);
    }

    @Override
    public Map<Enum<Group>, List<EmailAddress>> getDependedEmailsByBooksCount() {
        Map<Reader, Integer> readerCountBookMap = getReaderCountBookByReaderMap();
        Map<Enum<Group>, List<EmailAddress>> enumEmailMap = new HashMap<>();
        List<EmailAddress> okEmailAddresses = new ArrayList<>();
        List<EmailAddress> tooMuchEmailAddresses = new ArrayList<>();
        for (Map.Entry<Reader, Integer> entry : readerCountBookMap.entrySet()) {
            EmailAddress email = entry.getKey().email();
            if (entry.getValue() < MAX_NUMBER_OF_BOOKS_TAKEN_TO_OK_LIST) {
                okEmailAddresses.add(email);
            } else {
                tooMuchEmailAddresses.add(email);
            }
        }
        enumEmailMap.put(OK, okEmailAddresses);
        enumEmailMap.put(TOO_MUCH, tooMuchEmailAddresses);
        return enumEmailMap;
    }

    @Override
    public Map<Enum<Group>, List<String>> getReadersFullNamesByEmailsGroups() {
        Map<Reader, Integer> readerCountBookMap = getReaderCountBookByReaderMap();
        Map<Enum<Group>, List<String>> enumFullNameMap = new HashMap<>();
        List<String> okFullNameGroups = new ArrayList<>();
        List<String> tooMuchFullNameGroups = new ArrayList<>();
        for (Map.Entry<Reader, Integer> entry : readerCountBookMap.entrySet()) {
            String fullName = entry.getKey().fullName();
            if (entry.getValue() < MAX_NUMBER_OF_BOOKS_TAKEN_TO_OK_LIST) {
                okFullNameGroups.add(fullName);
            } else {
                tooMuchFullNameGroups.add(fullName);
            }
        }
        enumFullNameMap.put(OK, okFullNameGroups);
        enumFullNameMap.put(TOO_MUCH, tooMuchFullNameGroups);
        return enumFullNameMap;
    }

    @Override
    public String getReaderFullNameByEmailGroupWithFormatting() {
        Map<Enum<Group>, List<String>> enumFullNameMap = getReadersFullNamesByEmailsGroups();
        Map<Enum<Group>, String> valueFormattedMap = new HashMap<>();
        String okValueFormattedStr = getFormattingStr(enumFullNameMap, OK);
        String tooMuchValueFormattedStr = getFormattingStr(enumFullNameMap, TOO_MUCH);
        valueFormattedMap.put(OK, okValueFormattedStr);
        valueFormattedMap.put(TOO_MUCH, tooMuchValueFormattedStr);
        return convertMapToFormattedStr(valueFormattedMap);
    }

    private String convertMapToFormattedStr(Map<Enum<Group>, String> map) {
        return map.keySet().stream()
                .map(key -> key + " " + map.get(key))
                .collect(Collectors.joining("\n"));
    }

    private String getFormattingStr
            (Map<Enum<Group>, List<String>> enumFullNameMap, Enum<Group> group) {
        List<String> fullNameGroups = enumFullNameMap.get(group);
        return fullNameGroups.stream()
                .collect(Collectors.joining(", ", "{", "}"));
    }

    private Map<Reader, Integer> getReaderCountBookByReaderMap() {
        return library.readers().stream()
                .collect(Collectors.toMap(Function.identity(), reader -> reader.takenBooks().size()));
    }
}