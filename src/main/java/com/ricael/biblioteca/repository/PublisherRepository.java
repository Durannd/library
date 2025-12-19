package com.ricael.biblioteca.repository;

import com.ricael.biblioteca.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<List<Publisher>> findByNameLike(String name);
}
