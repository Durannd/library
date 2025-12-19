package com.ricael.biblioteca.controller.response;

import java.time.Instant;

public record LoanResponse(Long id,
                           Long userId,
                           Long bookId,
                           Instant loanDate,
                           Instant returnDate) {
}
