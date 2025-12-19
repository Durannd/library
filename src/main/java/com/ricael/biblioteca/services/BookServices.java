package com.ricael.biblioteca.services;

import com.ricael.biblioteca.model.Book;
import com.ricael.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No books found for id: " + id));
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getBooksByPublisher(String name){
        return bookRepository.findByPublisher(name).orElseThrow(() -> new RuntimeException("No books found for publisher: " + name));
    }

    public List<Book> getBooksByAuthor(String name){
        return bookRepository.findByAuthor(name).orElseThrow(() -> new RuntimeException("No books found for author: " + name));
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("No books found for title: " + title));
    }

}
