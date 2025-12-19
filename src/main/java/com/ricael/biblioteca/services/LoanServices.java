package com.ricael.biblioteca.services;

import com.ricael.biblioteca.model.Loan;
import com.ricael.biblioteca.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServices {
    @Autowired
    LoanRepository loanRepository;

    public List<Loan> getLoansByUserId(Long id) {
        return loanRepository.findByUserId(id).orElseThrow(() -> new RuntimeException("No loans found for user with id: " + id));
    }

    public List<Loan> getLoansByBookId(Long id) {
        return loanRepository.findByBookId(id);
    }

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public void deleteLoansByBookId(Long id) {
        List<Loan> loans = loanRepository.findByBookId(id);
        loanRepository.deleteAll(loans);
    }

    public void updateLoan(Loan loan) {
        loanRepository.save(loan);
    }

}
