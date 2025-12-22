package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.BookRequest;
import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.BookResponse;
import com.ricael.biblioteca.mappers.BookMapper;
import com.ricael.biblioteca.mappers.PublisherMapper;
import com.ricael.biblioteca.model.Book;
import com.ricael.biblioteca.model.Publisher;
import com.ricael.biblioteca.services.BookServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @Operation(description = "Get all books")
    @ApiResponse(responseCode = "200", description = "Books retrieved successfully")
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {

        return ResponseEntity.ok(bookServices.findAll());
    }

    @Operation(description = "Get books by author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No books found for the given author")
    })
    @GetMapping("by-author")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(bookServices.getBooksByAuthor(author));
    }

    @Operation(description = "Get books by title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No books found for the given title")
    })
    @GetMapping("by-title")
    public ResponseEntity<List<BookResponse>> getBooksByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookServices.getBooksByTitle(title));
    }

    @Operation(description = "Get books by publisher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No books found for the given publisher")
    })
    @GetMapping("by-publisher")
    public ResponseEntity<List<BookResponse>> getBooksByPublisher(@RequestBody PublisherRequest publisher) {

        return ResponseEntity.ok(bookServices.getBooksByPublisher(publisher));
    }

    @Operation(description = "Get book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No book found for the given ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookServices.getBookById(id));
    }

    @Operation(description = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created book"),
    })
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest book) {
        Book savedBook = bookServices.saveBook(BookMapper.toEntity(book));
        return ResponseEntity.ok(BookMapper.toResponse(savedBook));
    }
}
