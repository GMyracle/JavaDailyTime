package com.app.bookApp.service.bookinterface;

import com.app.bookApp.dataaccess.BookEntity;


import java.util.List;

public interface BookInterface {

    List<BookEntity> getAllBook();

    List<BookEntity> getBookById(Integer id);

    BookEntity bookDetail(Integer id);

    void deleteBook(Integer id);

    BookEntity updateBook(BookEntity bookEntity);

    void save(BookEntity bookEntity);

    void createBook(BookEntity bookEntity);
}
