package com.responsywnie.thymleaf.service;

import com.responsywnie.thymleaf.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Component
public class BookServiceValidator {

   Set<Book>books;

   private Validator validator;

   @Autowired
    public BookServiceValidator(Validator validator) {
        this.books = new HashSet<>();
        this.validator = validator;
    }

    public void addBook(Book book){
       Set<ConstraintViolation<Book>>error=validator.validate(book);
       if (!error.isEmpty()){
           error.forEach(err -> System.out.println(err.getMessage()));
       }else {
           books.add(book);
       }
    }

    public Set<Book> getBooks(){
       return this.books;
    }
}
