package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByBook_Id(Long bookId);

    List<Review> findByUser_Id(Long userId);

}
