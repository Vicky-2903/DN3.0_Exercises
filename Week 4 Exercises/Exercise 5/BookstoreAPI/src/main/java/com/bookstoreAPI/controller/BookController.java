package com.bookstoreAPI.controller;

import com.bookstoreAPI.entity.Book;
import com.bookstoreAPI.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        String responseMessage = bookService.saveBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseMessage);
    }

    @PostMapping("/create-with-headers")
    public ResponseEntity<String> createBookWithHeaders(@RequestBody Book book) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomValue");
        
        String responseMessage = bookService.saveBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .headers(headers)
                .body("Book created with headers: " + book);
    }
}
