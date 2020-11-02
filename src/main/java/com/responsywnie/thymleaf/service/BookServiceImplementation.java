package com.responsywnie.thymleaf.service;

import com.responsywnie.thymleaf.dao.BookDAO;
import com.responsywnie.thymleaf.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookDAO.save(book);
    }

    @Override
    public Book getBookByID(long id) {
        Optional<Book>optionalBook=bookDAO.findById(id);
        Book book = null;
        if (optionalBook.isPresent()){
            book = optionalBook.get();//Optional pobiera listę książek
        }else
            throw new RuntimeException("Książka nie znaleziona po ID :: " + id);
        return book;
    }

    @Override
    public void deleteBook(long id) {
        this.bookDAO.deleteById(id);
    }

}
