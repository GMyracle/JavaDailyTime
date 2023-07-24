package com.app.bookApp.dataaccess;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.print.Book;

@Entity // This tells Hibernate to make a table out of this class
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "testbook")
@Getter
@Setter
@NoArgsConstructor
public class BookEntity {

    @Id

    private int id;


    private String title;


    private String author;


    private int year;




}

