package com.app.bookApp.controller;


import com.app.bookApp.dataaccess.BookEntity;
import com.app.bookApp.dataaccess.BookTest;
import com.app.bookApp.exception.BookNotFoundException;
import com.app.bookApp.repository.BookRepository;
import com.app.bookApp.response.BookErrorResponse;
import com.app.bookApp.service.impl.BookImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookmanagement")
public class BookController {
    @Autowired
    BookImpl bookImpl;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getdetail")
    public String getDetailBook(@RequestParam Integer id) {
        bookImpl.bookDetail(id);
        return "Success";

    }

    @GetMapping("/deletebook")
    public String deleteBook(@RequestParam Integer id) {
        bookImpl.deleteBook(id);
        return "Success";

    }

    @GetMapping("/updatebook")
    public String updateBook(@RequestBody BookEntity bookEntity) {
        bookImpl.updateBook(bookEntity);
        return "Success";
    }

    @PostMapping("/createbook")
    public void createBook(@RequestBody BookEntity bookEntity) {
        bookImpl.createBook(bookEntity);
    }

//    @ExceptionHandler
//    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exc) {
//
//        BookErrorResponse error = new BookErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
}