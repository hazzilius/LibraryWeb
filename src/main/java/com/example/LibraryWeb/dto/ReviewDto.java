package com.example.LibraryWeb.dto;

import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.model.User;

import java.time.LocalDate;

public class ReviewDto {
    private String text;

    public ReviewDto() {
    }

    public ReviewDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
