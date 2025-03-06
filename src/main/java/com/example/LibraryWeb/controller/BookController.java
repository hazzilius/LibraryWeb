package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    String book(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "book";
    }

    @GetMapping("/book")
    String bookList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }
}
