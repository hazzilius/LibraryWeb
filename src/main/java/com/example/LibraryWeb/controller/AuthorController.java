package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.service.AuthorService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/author")
    String authorList(Model model,
                    @RequestParam(defaultValue = "") String search,
                    @RequestParam(defaultValue = "0") @Min(0) Integer offset,
                    @RequestParam(defaultValue = "20") @Min(1) @Max(100) Integer limit){
        model.addAttribute("search", search);
        model.addAttribute("authors", !search.isBlank() ?
                authorService.findByName(search, offset, limit) : authorService.findAll(offset, limit));
        model.addAttribute("pageTitle", !search.isBlank() ?
                String.format("Поиск - %s", search) : "Список авторов");
        return "authorList";
    }
}
