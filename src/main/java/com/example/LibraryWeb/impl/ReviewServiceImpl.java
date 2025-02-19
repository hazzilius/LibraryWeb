package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.model.Review;
import com.example.LibraryWeb.repository.ReviewRepo;
import com.example.LibraryWeb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> findByBookId(Long id) {
        return reviewRepo.findByBookId(id);
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }
}
