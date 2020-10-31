package com.responsywnie.thymleaf.controller;

import com.responsywnie.thymleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
        public String get (Model model){
        model.addAttribute("listBooks",bookService.getAllBooks());
        return "helloo";
    }
}
