package com.responsywnie.thymleaf.service;

import com.responsywnie.thymleaf.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    List<Book>getAllBooks();
}
