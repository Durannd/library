package com.ricael.biblioteca.mappers;

import com.ricael.biblioteca.controller.request.LoanRequest;
import com.ricael.biblioteca.controller.response.LoanResponse;
import com.ricael.biblioteca.model.Loan;

public class LoanMapper {
    private LoanMapper() {}
    public static Loan toEntity(LoanRequest loanRequest){
        if(loanRequest == null){
            return null;
        }

        Loan loan = new Loan();
        loan.setBookId(loanRequest.bookId());
        loan.setUserId(loanRequest.userId());
        loan.setLoanDate(loanRequest.loanDate());
        loan.setReturnDate(loanRequest.returnDate());
        return loan;
    }

    public static LoanResponse toResponse(Loan loan){
        if(loan == null){
            return null;
        }
        return new LoanResponse(
            loan.getId(),
            loan.getBookId(),
            loan.getUserId(),
            loan.getLoanDate(),
            loan.getReturnDate()
        );
    }
}
