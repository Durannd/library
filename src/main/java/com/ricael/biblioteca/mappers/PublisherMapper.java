package com.ricael.biblioteca.mappers;

import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.PublisherResponse;
import com.ricael.biblioteca.model.Publisher;

public class PublisherMapper {
    private PublisherMapper() {}

    public static Publisher toEntity(PublisherRequest request){
        if (request == null) {
            return null;
        }
        return new Publisher(
                request.id(),
                request.name(),
                request.address(),
                request.phone(),
                request.email(),
                request.books()
        );
    }

    public static PublisherResponse toResponse(Publisher publisher){
        if (publisher == null) {
            return null;
        }
        return new PublisherResponse(
                publisher.getId(),
                publisher.getName(),
                publisher.getAddress(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getBooks()
        );
    }
}
