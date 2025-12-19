package com.ricael.biblioteca.controller.response;

import com.ricael.biblioteca.model.Book;

import java.util.List;

public record PublisherResponse(Long id,
                                String name,
                                String address,
                                String phone,
                                String email,
                                List<Book> books) {
}
