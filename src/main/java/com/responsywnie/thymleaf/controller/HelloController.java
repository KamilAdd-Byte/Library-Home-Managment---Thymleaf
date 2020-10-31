package com.responsywnie.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
        public String get (Model model){
        model.addAttribute("name","I learn thymleaf");
        return "helloo";
    }
}
