package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.BookRequest;
import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.BookResponse;
import com.ricael.biblioteca.mappers.BookMapper;
import com.ricael.biblioteca.mappers.PublisherMapper;
import com.ricael.biblioteca.model.Book;
import com.ricael.biblioteca.model.Publisher;
import com.ricael.biblioteca.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {

        return ResponseEntity.ok(bookServices.findAll());
    }

    @GetMapping("by-author")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(bookServices.getBooksByAuthor(author));
    }

    @GetMapping("by-title")
    public ResponseEntity<List<BookResponse>> getBooksByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookServices.getBooksByTitle(title));
    }

    @GetMapping("by-publisher")
    public ResponseEntity<List<BookResponse>> getBooksByPublisher(@RequestBody PublisherRequest publisher) {

        return ResponseEntity.ok(bookServices.getBooksByPublisher(publisher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookServices.getBookById(id));
    }

    @PutMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest book) {
        Book savedBook = bookServices.saveBook(BookMapper.toEntity(book));
        return ResponseEntity.ok(BookMapper.toResponse(savedBook));
    }
}
