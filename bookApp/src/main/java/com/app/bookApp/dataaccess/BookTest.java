package com.app.bookApp.dataaccess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTest {

    private int id;


    private String title;


    private String author;


    private int year;

    public BookTest(){

    }

    public BookTest(int id, String title, String author) {
    }
}
