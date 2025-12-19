package com.ricael.biblioteca.mappers;

import com.ricael.biblioteca.controller.request.BookRequest;
import com.ricael.biblioteca.controller.response.BookResponse;
import com.ricael.biblioteca.model.Book;

public class BookMapper {
    private BookMapper() {}

    public static Book toEntity(BookRequest bookRequest) {
        if (bookRequest == null) {
            return null;
        }
        return new Book(
                null,
                bookRequest.title(),
                bookRequest.author(),
                bookRequest.isbn(),
                bookRequest.publishedYear(),
                bookRequest.publisher()
        );
    }

    public static BookResponse toResponse(Book book) {
        if (book == null) {
            return null;
        }
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedYear(),
                book.getPublisher()
        );
    }
}
