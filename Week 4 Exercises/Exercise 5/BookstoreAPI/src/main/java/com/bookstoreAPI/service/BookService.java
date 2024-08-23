package com.bookstoreAPI.service;

import com.bookstoreAPI.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public String saveBook(Book book) {
        // Here you would save the book to the database
        // For simplicity, just return a success message
        return "Book saved: " + book;
    }
}
