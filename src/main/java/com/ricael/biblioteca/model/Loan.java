package com.ricael.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@Table(name = "tb_loans")
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long bookId;

    private Instant loanDate;


    private Instant returnDate;

    @PrePersist
    protected void onCreate() {
        this.loanDate = Instant.now();
        this.returnDate = this.loanDate.plus(30, ChronoUnit.DAYS);
    }
}
