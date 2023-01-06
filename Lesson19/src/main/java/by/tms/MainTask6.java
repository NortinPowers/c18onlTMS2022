package by.tms;

import by.tms.model.Book;
import by.tms.model.EmailAddress;
import by.tms.model.Library;
import by.tms.model.Reader;
import by.tms.service.LibraryService;
import by.tms.service.LibraryServiceAware;

import java.util.Arrays;
import java.util.List;

public class MainTask6 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(1L, "Лев Толстой", "Смерть Ивана Ильича", 1886),
                new Book(2L, "Фёдор Михайлович Достоевский", "Преступление и наказание", 1886),
                new Book(3L, "Чарлз Диккенс", "Повесть о двух городах", 1859),
                new Book(4L, "Чарлз Диккенс", "Оливер Твист", 1839),
                new Book(5L, "Антон Павлович Чехов", "Вишнёвый сад", 1901),
                new Book(6L, "Антон Павлович Чехов", "Попрыгунья", 1891),
                new Book(7L, "Виктор Гюго", "Человек, который смеётся", 1860),
                new Book(8L, "Виктор Гюго", "Собор Парижской Богоматери", 1831),
                new Book(9L, "Виктор Гюго", "Отверженные", 1862),
                new Book(10L, "Эрнест Хемингуэй", "По ком звонит колокол", 1940),
                new Book(11L, "Эрнест Хемингуэй", "Снега Килиманджаро", 1936),
                new Book(12L, "Александр Сергеевич Пушкин", "Руслан и Людмила", 1820),
                new Book(13L, "Александр Сергеевич Пушкин", "Медный всадник", 1833),
                new Book(14L, "Александр Сергеевич Пушкин", "Борис Годунов", 1825));


        List<Reader> readers = Arrays.asList(
                new Reader(1L, "Платонова Есения Алексеевна", new EmailAddress("Платонова@mail.ru", ""), false, null),
                new Reader(2L, "Антипов Григорий Максимович", new EmailAddress("Антипов@mail.ru", ""), true, null),
                new Reader(3L, "Козлова Маргарита Максимовна", new EmailAddress("Козлова@mail.ru", ""), false, null),
                new Reader(4L, "Голубева Виктория Дмитриевна", new EmailAddress("Голубева@mail.ru", ""), true, null),
                new Reader(5L, "Боброва Яна Дмитриевна", new EmailAddress("Боброва@mail.ru", ""), true, null),
                new Reader(6L, "Иванов Егор Александрович", new EmailAddress("Иванов@mail.ru", ""), false, null),
                new Reader(7L, "Воробьев Эмин Алексеевич", new EmailAddress("Воробьев@mail.ru", ""), false, null),
                new Reader(8L, "Тихомирова Кристина Никитична", new EmailAddress("Тихомирова@mail.ru", ""), true, null),
                new Reader(9L, "Лобанова Елизавета Константиновна", new EmailAddress("Лобанова@mail.ru", ""), false, null),
                new Reader(10L, "Соколов Георгий Макарович", new EmailAddress("Соколов@mail.ru", ""), false, null));

        LibraryServiceAware libraryService = new LibraryService(new Library(books, readers));
        libraryService.setBookToReader(1, 1);
        libraryService.setBookToReader(2, 4);
        libraryService.setBookToReader(2, 3);
        libraryService.setBookToReader(3, 1);
        libraryService.setBookToReader(3, 5);
        libraryService.setBookToReader(4, 13);
        libraryService.setBookToReader(6, 12);
        System.out.println(libraryService.getBookByYear());
        System.out.println(libraryService.getAllEmail());
        System.out.println();
        System.out.println(libraryService.getConcertedEmail());
        System.out.println();
        System.out.println(libraryService.getTakenBook());
        System.out.println();
        System.out.println(libraryService.getReadersWhoTakenBookByAuthor("Александр Сергеевич Пушкин"));
    }
}