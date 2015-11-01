package ru.dnevnik.aop.repository;

import ru.dnevnik.aop.annotation.Loggable;
import ru.dnevnik.aop.entity.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@Loggable
public class BookRepository {

    private Map<Integer, Book> books;

    public BookRepository() {
        books = new HashMap<>();

        for (int i = 1; i < 50; i++) {
            books.put(i, new Book(i, "Book #" + i));
        }
    }

    public Book findOne(Integer id) {
        return books.get(id);
    }

    //Вернули книгу
    public Book put(Integer id, String name) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        return book;
    }

    //Взяли книгу
    public Book get(Integer id) {
        return books.remove(id);
    }
}
