package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.model.Review;
import com.example.LibraryWeb.service.BookService;
import com.example.LibraryWeb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final BookService bookService;

    public ReviewController(ReviewService reviewService, BookService bookService) {
        this.reviewService = reviewService;
        this.bookService = bookService;
    }

    @GetMapping("reviews/new")
    public String showReviewForm(Model model, Long bookId){
        model.addAttribute("review", new Review());
        model.addAttribute("book", bookService.findById(bookId));
        return "review-form";
    }

    @PostMapping("/reviews")
    public String addReview(Review review){
        reviewService.addReview(review);
        return "redirect:/books";
    }

    @GetMapping("/reviews/{bookId}")
    public String listReviews(@PathVariable("bookId") Long bookId, Model model){
        model.addAttribute("reviews", reviewService.findByBookId(bookId));
        model.addAttribute("book", bookService.findById(bookId));
        return "book-reviews";
    }
}
