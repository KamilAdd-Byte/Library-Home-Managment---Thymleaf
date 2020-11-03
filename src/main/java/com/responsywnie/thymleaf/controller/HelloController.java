package com.responsywnie.thymleaf.controller;

import com.responsywnie.thymleaf.model.Book;
import com.responsywnie.thymleaf.service.BookService;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

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
        return "new_book";
    }
    @PostMapping("/")
    public String consumeForm(@Valid @ModelAttribute Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<ObjectError>errorList = bindingResult.getAllErrors();
            errorList.forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }
        return "new_book";
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
        return "update_book";
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable (value = "id") long id){
        this.bookService.deleteBook(id);
        return "redirect:/";
    }
}
