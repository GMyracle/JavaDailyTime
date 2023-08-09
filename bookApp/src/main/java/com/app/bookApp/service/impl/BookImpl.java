package com.app.bookApp.service.impl;

import com.app.bookApp.dataaccess.BookEntity;
import com.app.bookApp.exception.BookExistException;
import com.app.bookApp.exception.BookNotFoundException;
import com.app.bookApp.repository.BookRepository;
import com.app.bookApp.response.ResponseData;
import com.app.bookApp.service.bookinterface.BookInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookImpl implements BookInterface {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> getAllBook() {

        return null;
    }

    @Override
    public List<BookEntity> getBookById(Integer id) {
        return null;
    }

    @Override
    public BookEntity bookDetail(Integer id) {
        if (bookRepository.existsById(id)) {
            BookEntity bookEntity = bookRepository.getById(id);
            System.out.println(bookEntity);
            System.out.println(bookRepository.getById(id).getTitle());
            return bookEntity ;
        } else {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    public BookEntity deleteBook(Integer id) {

        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
        return bookDetail(id);
    }

    @Override
    public BookEntity updateBook(BookEntity bookEntity) {


        if (bookRepository.existsById(bookEntity.getId())) {
            // Nếu cuốn sách tồn tại, thực hiện cập nhật thông tin
            BookEntity existingBook = bookRepository.getById(bookEntity.getId());
            existingBook.setAuthor(bookEntity.getAuthor());
            existingBook.setTitle(bookEntity.getTitle());
            existingBook.setYear(bookEntity.getYear());

            // Lưu cuốn sách đã cập nhật vào cơ sở dữ liệu
            return bookRepository.save(existingBook);
        } else {
            // Nếu cuốn sách không tồn tại, ném ngoại lệ hoặc trả về null (tuỳ bạn)
            throw new BookNotFoundException(bookEntity.getId());
        }
    }

    @Override
    public void save(BookEntity bookEntity) {

        bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity createBook(BookEntity bookEntity) {

        bookRepository.existsById(bookEntity.getId());

        if (bookRepository.existsById(bookEntity.getId()) == false) {
            BookEntity existingBook = new BookEntity();
            existingBook.setId(bookEntity.getId());
            existingBook.setAuthor(bookEntity.getAuthor());
            existingBook.setTitle(bookEntity.getTitle());
            existingBook.setYear(bookEntity.getYear());
            bookRepository.save(existingBook);
            return existingBook;
        } else {
            try {
                throw new BookExistException(" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
