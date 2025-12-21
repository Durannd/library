package com.ricael.biblioteca.repository;

import com.ricael.biblioteca.model.Book;
import com.ricael.biblioteca.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findByPublisher(Publisher publisher);
    Optional<List<Book>> findByAuthor(String author);
    Optional<List<Book>> findByTitle(String title);

}
