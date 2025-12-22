package com.ricael.biblioteca.controller.request;

import java.time.Instant;

public record LoanRequest(Long userId,
                          Long bookId) {
}
