package com.example.LibraryWeb.service;

import com.example.LibraryWeb.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByBookId(Long id);
    Review addReview(Review review);
}
