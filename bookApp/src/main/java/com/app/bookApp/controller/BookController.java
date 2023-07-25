package com.app.bookApp.controller;


import com.app.bookApp.dataaccess.BookEntity;
import com.app.bookApp.repository.BookRepository;
import com.app.bookApp.response.ResponseHandler;
import com.app.bookApp.service.impl.BookImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import javax.xml.ws.http.HTTPException;

@Controller
@RequestMapping("/bookmanagement")
public class BookController {
    @Autowired
    BookImpl bookImpl;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getdetail")
    public ResponseEntity<Object> getDetailBook(@RequestParam Integer id) {
        return ResponseHandler.responseBuilder("Requested data are given here",
                ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED(200 OK)"),
                bookImpl.bookDetail(id));
    }

    @DeleteMapping("/deletebook")
    public ResponseEntity<Object> deleteBook(@RequestParam Integer id) {
        return ResponseHandler.responseBuilder("Data deleted",
                ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED(200 OK)"),
                bookImpl.deleteBook(id));

    }

    @PutMapping("/updatebook")
    public ResponseEntity<Object> updateBook(@RequestBody BookEntity bookEntity) {
        return ResponseHandler.responseBuilder("Data updated",
                ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED(200 OK)"),
                bookImpl.updateBook(bookEntity));
//        bookImpl.updateBook(bookEntity);
//        return "Success";
    }

    @PostMapping("/createbook")
    public ResponseEntity<Object> createBook(@RequestBody BookEntity bookEntity) {
        return ResponseHandler.responseBuilder("Data created",
                ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED(200 OK)"),
                bookImpl.createBook(bookEntity));

    }


}