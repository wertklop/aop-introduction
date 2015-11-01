package ru.dnevnik.aop.aspectj;

import ru.dnevnik.aop.entity.Book;
import ru.dnevnik.aop.repository.BookRepository;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
public class TestNativeAspectJ {

    public static void main(String[] args) {
        Book book = new BookRepository().get(1);
        System.out.println(book.getName());
    }
}
