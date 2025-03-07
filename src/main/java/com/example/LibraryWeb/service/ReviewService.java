package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.ReviewDto;
import com.example.LibraryWeb.model.Review;

import java.util.List;

public interface ReviewService {

    void save(Long id, ReviewDto reviewDto);
    List<Review> findByBook_Id(Long id);
    Review findById(Long id);
    void delete(Long id);
}
