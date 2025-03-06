package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String admin(){
        return "admin/admin";
    }

    //TODO
//    @GetMapping("/admin/book")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    String adminBook(){
//        return "admin/adminBook";
//    }

    @PostMapping("/saveBook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String save(@ModelAttribute("book") BookDto bookDto){
        bookService.save(bookDto);
        return "redirect:/admin";
    }

    //TODO
    @PostMapping("deleteBook/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String delete(@PathVariable("id") Long id){
        bookService.deleteById(id);
        return "redirect:/admin";
    }
}
