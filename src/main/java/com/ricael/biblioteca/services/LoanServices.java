package com.ricael.biblioteca.services;

import com.ricael.biblioteca.controller.request.LoanRequest;
import com.ricael.biblioteca.controller.response.LoanResponse;
import com.ricael.biblioteca.mappers.LoanMapper;
import com.ricael.biblioteca.model.Loan;
import com.ricael.biblioteca.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServices {
    @Autowired
    private LoanRepository loanRepository;

    public List<LoanResponse> getLoansByUserId(Long id) {
        return loanRepository.findByUserId(id).orElseThrow(() -> new RuntimeException("No loans found for user with id: " + id))
                .stream()
                .map(LoanMapper::toResponse)
                .toList();
    }

    public List<LoanResponse> getLoansByBookId(Long id) {
        return loanRepository.findByBookId(id)
                .stream()
                .map(LoanMapper::toResponse)
                .toList();
    }

    public LoanResponse saveLoan(LoanRequest loan) {
        return LoanMapper.toResponse(loanRepository.save(LoanMapper.toEntity(loan)));
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
