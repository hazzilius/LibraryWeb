package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.ReviewDto;
import com.example.LibraryWeb.model.Review;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ReviewService {

    void save(Long id, ReviewDto reviewDto);
    Slice<Review> findByBook_Id(Long id, Integer offset, Integer limit);
    Review findById(Long id);
    void delete(Long id);
}
