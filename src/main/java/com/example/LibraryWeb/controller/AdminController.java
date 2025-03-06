package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.model.Author;
import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.service.AuthorService;
import com.example.LibraryWeb.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final BookService bookService;
    private final AuthorService authorService;

    public AdminController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @ModelAttribute("book")
    public BookDto bookDto(){
        return new BookDto();
    }

    @ModelAttribute("author")
    public AuthorDto author(){
        return new AuthorDto();
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    String admin(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "admin/admin";

    }

    //Book
    @PostMapping("/admin/saveBook")
    @PreAuthorize("hasAuthority('ADMIN')")
    String saveBook(@ModelAttribute("book") BookDto bookDto){
        bookService.save(bookDto);
        return "redirect:/admin?BookSuccess";
    }

    @PostMapping("/admin/deleteBook/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String deleteBook(@PathVariable("id") Long id){
        bookService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/editBook/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String editBook(@PathVariable("id") Long id, BookDto bookDto){
        bookService.edit(bookService.findById(id), bookDto);
        return "redirect:/book/{id}";
    }

    @GetMapping("/admin/edit/book/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String editBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("bookObject", bookService.findById(id));
        return "admin/bookEdit";
    }

    //Author
    @PostMapping("/admin/saveAuthor")
    @PreAuthorize("hasAuthority('ADMIN')")
    String saveAuthor(@ModelAttribute("author") AuthorDto authorDto){
        authorService.save(authorDto);
        return "redirect:/admin?AuthorSuccess";
    }

    @PostMapping("/admin/deleteAuthor/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/editAuthor/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String editAuthor(@PathVariable("id") Long id, AuthorDto authorDto){
        authorService.edit(authorService.findById(id), authorDto);
        return "redirect:/author/{id}";
    }

    @GetMapping("/admin/edit/author/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String editAuthor(@PathVariable("id") Long id, Model model){
        model.addAttribute("author", authorService.findById(id));
        return "admin/authorEdit";
    }
}
