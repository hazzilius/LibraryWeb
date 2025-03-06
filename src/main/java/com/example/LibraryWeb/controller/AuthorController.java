package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author/{id}")
    String author(@PathVariable("id") Long id, Model model){
        model.addAttribute("author", authorService.findById(id));
        return "author";
    }
}
