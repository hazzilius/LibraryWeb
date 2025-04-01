package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.dto.ReviewDto;
import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.service.BookService;
import com.example.LibraryWeb.service.ReviewService;
import com.example.LibraryWeb.service.UserService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService bookService;
    private final ReviewService reviewService;
    private final UserService userService;

    public BookController(BookService bookService, ReviewService reviewService, UserService userService) {
        this.bookService = bookService;
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @ModelAttribute("review")
    public ReviewDto reviewDto(){
        return new ReviewDto();
    }

    @GetMapping("/book/{id}")
    String book(@PathVariable("id") Long id, Model model,
                @RequestParam(defaultValue = "0") @Min(0) Integer offset,
                @RequestParam(defaultValue = "20") @Min(1) @Max(100) Integer limit){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("reviews", reviewService.findByBook_Id(id, offset, limit));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userService.findUser(auth.getName()));
        return "book";
    }

    @PostMapping("/addReview/{id}")
    String addReview(@PathVariable("id") Long id, ReviewDto reviewDto){
        reviewService.save(id, reviewDto);
        return "redirect:/book/{id}";
    }

    @GetMapping("/book")
    String bookList(Model model,
                    @RequestParam(defaultValue = "") String search,
                    @RequestParam(defaultValue = "0") @Min(0) Integer offset,
                    @RequestParam(defaultValue = "20") @Min(1) @Max(100) Integer limit){
        model.addAttribute("search", search);
        model.addAttribute("books", !search.isBlank() ?
                bookService.findByTitle(search, offset, limit) : bookService.findAll(offset, limit));
        model.addAttribute("pageTitle", !search.isBlank() ?
                String.format("Поиск - %s", search) : "Список книг");
        return "bookList";
    }

    @PostMapping("/deleteReview/{bookId}/{id}")
    String deleteReview(@PathVariable("id") Long id, @PathVariable("bookId") Long bookId){
        reviewService.delete(id);
        return "redirect:/book/{bookId}";
    }
}
