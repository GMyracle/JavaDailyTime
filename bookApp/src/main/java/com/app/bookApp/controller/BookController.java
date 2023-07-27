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

@Controller
@RequestMapping("/bookmanagement")
public class BookController {
    @Autowired
    BookImpl bookImpl;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getdetail")
    public ResponseData<Object> getDetailBook(@RequestParam Integer id) {
        return ResponseData.ok(bookImpl.bookDetail(id), "OK", "Data book detail given here");
    }

    @DeleteMapping("/deletebook")
    public ResponseData<Object> deleteBook(@RequestParam Integer id) {
        return ResponseData.ok(bookImpl.deleteBook(id), "OK", "Data book detail given here");

    }

    @PutMapping("/updatebook")
    public ResponseData<Object> updateBook(@RequestBody BookEntity bookEntity) {

        return ResponseData.ok(bookImpl.updateBook(bookEntity), "OK", "Data book detail given here");

    }

    @PostMapping("/createbook")
    public ResponseData<Object> createBook(@RequestBody BookEntity bookEntity) {

        return ResponseData.ok(bookImpl.createBook(bookEntity), "OK", "Data book detail given here");

    }


}