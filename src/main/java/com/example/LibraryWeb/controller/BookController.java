package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.dto.ReviewDto;
import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.service.BookService;
import com.example.LibraryWeb.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private final BookService bookService;
    private final ReviewService reviewService;

    public BookController(BookService bookService, ReviewService reviewService) {
        this.bookService = bookService;
        this.reviewService = reviewService;
    }

    @ModelAttribute("review")
    public ReviewDto reviewDto(){
        return new ReviewDto();
    }

    @GetMapping("/book/{id}")
    String book(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("reviews", reviewService.findByBook_Id(id).reversed());
        return "book";
    }

    @PostMapping("/addReview/{id}")
    String addReview(@PathVariable("id") Long id, ReviewDto reviewDto){
        reviewService.save(id, reviewDto);
        return "redirect:/book/{id}";
    }

    @GetMapping("/book")
    String bookList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }
}
