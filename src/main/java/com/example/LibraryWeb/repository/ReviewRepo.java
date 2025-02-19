package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review,Long> {
    List<Review> findByBookId(Long bookId);
    List<Review> findByUserId(Long userId);
    List<Review> findByRating(byte rating);
}
