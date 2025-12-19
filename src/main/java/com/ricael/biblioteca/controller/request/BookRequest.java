package com.ricael.biblioteca.controller.request;

import com.ricael.biblioteca.model.Publisher;

public record BookRequest (
        String title,
        String author,
        String isbn,
        Long publisherId,
        int yearPublished,
        Publisher publisher) {
}
