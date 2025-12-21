package com.ricael.biblioteca.services;

import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.BookResponse;
import com.ricael.biblioteca.mappers.BookMapper;
import com.ricael.biblioteca.mappers.PublisherMapper;
import com.ricael.biblioteca.model.Book;
import com.ricael.biblioteca.model.Publisher;
import com.ricael.biblioteca.repository.BookRepository;
import com.ricael.biblioteca.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public BookResponse getBookById(Long id) {
        return BookMapper.toResponse(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No books found for id: " + id)));
    }

    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream().map(BookMapper::toResponse).toList();
    }

    @Transactional
    public Book saveBook(@NotNull Book book) {
        if (book.getPublisher() != null) {
            if (book.getPublisher().getId() != null) {

                Publisher existingPublisher = publisherRepository.findById(book.getPublisher().getId())
                        .orElseThrow(() -> new RuntimeException("Editora não encontrada"));


                book.setPublisher(existingPublisher);
            } else {

                Publisher newPublisher = publisherRepository.save(book.getPublisher());
                book.setPublisher(newPublisher);
            }
        }

        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public List<BookResponse> getBooksByPublisher(PublisherRequest publisher) {
        List<Book> books = bookRepository.findByPublisher(PublisherMapper.toEntity(publisher)).orElseThrow(() -> new RuntimeException("No books found for publisher: " + publisher));
        return books.stream().map(BookMapper::toResponse).toList();
    }

    public List<BookResponse> getBooksByAuthor(String name) {
        List<Book> books = bookRepository.findByAuthor(name).orElseThrow(() -> new RuntimeException("No books found for author: " + name));
        return books.stream().map(BookMapper::toResponse).toList();
    }

    public List<BookResponse> getBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("No books found for title: " + title));
        return books.stream().map(BookMapper::toResponse).toList();
    }

}
