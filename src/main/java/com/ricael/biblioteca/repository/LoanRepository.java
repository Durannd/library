package com.ricael.biblioteca.repository;

import com.ricael.biblioteca.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<List<Loan>> findByUserId(Long id);

    List<Loan> findByBookId(Long id);

}
