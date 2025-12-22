package com.ricael.biblioteca.services;

import com.ricael.biblioteca.controller.request.LoanRequest;
import com.ricael.biblioteca.controller.response.LoanResponse;
import com.ricael.biblioteca.mappers.LoanMapper;
import com.ricael.biblioteca.model.Loan;
import com.ricael.biblioteca.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public LoanResponse saveLoan(LoanRequest loan) {
        return LoanMapper.toResponse(loanRepository.save(LoanMapper.toEntity(loan)));
    }

    @Transactional
    public void deleteLoan(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new RuntimeException("Loan with id: " + id + " does not exist.");
        } else {

            loanRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteLoansByBookId(Long id) {
        List<Loan> loans = loanRepository.findByBookId(id);
        loanRepository.deleteAll(loans);
    }

    @Transactional
    public LoanResponse updateLoan(LoanRequest loan, Long id) {

        if (loanRepository.existsById(id)) {
            Loan l = LoanMapper.toEntity(loan);
            l.setId(id);
            return LoanMapper.toResponse(loanRepository.save(l));
        }
        throw new RuntimeException("Loan with id: " + id + " does not exist.");
    }

    public LoanResponse getById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan with id: " + id + " does not exist."));
        return LoanMapper.toResponse(loan);
    }

}
