package com.app.bookApp.controller;


import com.app.bookApp.dataaccess.BookEntity;
import com.app.bookApp.repository.BookRepository;
import com.app.bookApp.response.ResponseData;
import com.app.bookApp.service.impl.BookImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@Controller
@RequestMapping("/bookmanagement")
public class BookController {
    @Autowired
    BookImpl bookImpl;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getdetail")
    public ResponseEntity<ResponseData<Object>> getBookById(@RequestParam Integer id) {
        return ResponseEntity.ok(ResponseData.ok(bookImpl.bookDetail(id), HttpStatus.OK,
                "ABC", "Data book detail given here"));
    }

    @DeleteMapping("/deletebook")
    public ResponseEntity<ResponseData<BookEntity>> deleteBook(@RequestParam Integer id) {
        return ResponseEntity.ok(ResponseData.ok(bookImpl.deleteBook(id), HttpStatus.OK,
                "ABC", "Data book detail given here"));
    }

    @PutMapping("/updatebook")
    public ResponseEntity<ResponseData<BookEntity>> updateBook(@RequestBody BookEntity bookEntity) {
        return ResponseEntity.ok(ResponseData.ok(bookImpl.updateBook(bookEntity), HttpStatus.OK,
                "ABC", "Data book detail given here"));

    }

    @PostMapping("/createbook")
    public ResponseEntity<ResponseData<Object>> createBook(@RequestBody BookEntity bookEntity) {
        return ResponseEntity.ok(ResponseData.ok(bookImpl.createBook(bookEntity), HttpStatus.OK,
                "ABC", "Data book detail given here"));

    }


}