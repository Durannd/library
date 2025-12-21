package com.ricael.biblioteca.controller.request;

import com.ricael.biblioteca.model.Book;

import java.util.List;

public record PublisherRequest(
        Long id,
        String name,
        String address,
        String phone,
        String email,
        List<Book> books) {
}
