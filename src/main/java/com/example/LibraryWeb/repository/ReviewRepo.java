package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.model.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    Slice<Review> findByBook_IdOrderByDateDesc(PageRequest request, Long bookId);

    Slice<Review> findByUser_Id(PageRequest request, Long userId);

}
