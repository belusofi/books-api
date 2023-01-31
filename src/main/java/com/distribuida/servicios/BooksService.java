package com.distribuida.servicios;

import com.distribuida.db.Book;
import io.helidon.common.reactive.Multi;
import io.helidon.common.reactive.Single;



public interface BooksService {
    Single<Book> findById(Integer id);
    Multi<Book> findAll();
    Single<Book> pushBook(Book book);

    Single<Long> editBook(Book book, Integer id);

    Single<Long> deleteBook(Integer id);
}
