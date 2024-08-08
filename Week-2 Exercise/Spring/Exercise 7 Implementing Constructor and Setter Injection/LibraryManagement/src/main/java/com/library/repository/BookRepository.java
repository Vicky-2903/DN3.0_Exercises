package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void getBook() {
        System.out.println("Fetching book from the repository.");
    }
}
