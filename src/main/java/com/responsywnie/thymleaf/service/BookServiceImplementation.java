package com.responsywnie.thymleaf.service;

import com.responsywnie.thymleaf.dao.BookDAO;
import com.responsywnie.thymleaf.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
