package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("book")
    public BookDto bookDto(){
        return new BookDto();
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    String admin(){
        return "admin/admin";
    }

    @PostMapping("/saveBook")
    @PreAuthorize("hasAuthority('ADMIN')")
    String save(@ModelAttribute("book") BookDto bookDto){
        bookService.save(bookDto);
        return "redirect:/admin";
    }

    @PostMapping("/deleteBook/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String delete(@PathVariable("id") Long id){
        bookService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/editBook/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    String edit(@PathVariable("id") Book book, BookDto bookDto){
        bookService.edit(book, bookDto);
        return "redirect:/book/{id}";
    }

    @GetMapping("/book/{id}/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("bookObject", bookService.findById(id));
        return "admin/bookEdit";
    }
}
