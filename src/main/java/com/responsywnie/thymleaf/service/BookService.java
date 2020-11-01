package com.responsywnie.thymleaf.service;

import com.responsywnie.thymleaf.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    List<Book>getAllBooks();
    void saveBook(Book book);
    Book getBookByID(long id);
    void deleteBook(long id);
    List<Book> findBookByTitle(Book book);
}
