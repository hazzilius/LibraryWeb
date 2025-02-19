package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book-list";
    }

    @GetMapping("/books/new")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/books")
    public String addBook(Book book){
        bookService.save(book);
        return "redirect:/books";
    }
}
