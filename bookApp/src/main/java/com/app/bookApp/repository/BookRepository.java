package com.app.bookApp.repository;

import com.app.bookApp.dataaccess.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
