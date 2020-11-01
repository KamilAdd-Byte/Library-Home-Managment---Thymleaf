package com.responsywnie.thymleaf.controller;

import com.responsywnie.thymleaf.model.Book;
import com.responsywnie.thymleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
        public String get (Model model){
        model.addAttribute("listBooks",bookService.getAllBooks());
        return "helloo";
    }
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "new book";
    }
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/";
    }
    @GetMapping("/showBookFromUpdate/{id}")
    public String getBookByID(@PathVariable (value = "id") long id, Model model){
        Book book = bookService.getBookByID(id);
        model.addAttribute("book",book);
        return "update book";
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable (value = "id") long id){
        this.bookService.deleteBook(id);
        return "redirect:/";
    }
}
