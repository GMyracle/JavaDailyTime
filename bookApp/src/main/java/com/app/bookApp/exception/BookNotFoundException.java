package com.app.bookApp.exception;

import com.app.bookApp.dataaccess.BookEntity;
import com.app.bookApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Integer id){
        super("Không tìm thấy sách với id: "+ id);
    }


}
