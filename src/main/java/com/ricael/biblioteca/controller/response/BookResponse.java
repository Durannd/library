package com.ricael.biblioteca.controller.response;

import com.ricael.biblioteca.model.Publisher;
import lombok.experimental.UtilityClass;


public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        Long publisherId,
        int yearPublished,
        Publisher publisher) {
}
