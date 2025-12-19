package com.ricael.biblioteca.repository;

import com.ricael.biblioteca.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
}
