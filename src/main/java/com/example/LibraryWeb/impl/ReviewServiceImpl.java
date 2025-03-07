package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.dto.ReviewDto;
import com.example.LibraryWeb.model.Review;
import com.example.LibraryWeb.repository.BookRepo;
import com.example.LibraryWeb.repository.ReviewRepo;
import com.example.LibraryWeb.repository.UserRepo;
import com.example.LibraryWeb.service.ReviewService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public ReviewServiceImpl(ReviewRepo reviewRepo, UserRepo userRepo, BookRepo bookRepo) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void save(Long id, ReviewDto reviewDto) {
        if (bookRepo.findById(id).isPresent()){
            Review review = new Review();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            review.setUser(userRepo.findByUsername(auth.getName()));
            review.setBook(bookRepo.findById(id).get());
            review.setText(reviewDto.getText());
            review.setDate(LocalDate.now());
            reviewRepo.save(review);
        }
    }

    @Override
    public List<Review> findByBook_Id(Long id) {
        return reviewRepo.findByBook_Id(id);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Комментарий не найден!"));
    }

    @Override
    public void delete(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        reviewRepo.deleteById(id);
    }
}
