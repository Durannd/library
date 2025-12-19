package com.ricael.biblioteca.mappers;

import com.ricael.biblioteca.controller.request.BookRequest;
import com.ricael.biblioteca.controller.request.UserRequest;
import com.ricael.biblioteca.controller.response.BookResponse;
import com.ricael.biblioteca.controller.response.UserResponse;
import com.ricael.biblioteca.model.Book;
import com.ricael.biblioteca.model.User;


public class UserMapper {
    private UserMapper() {
    }

    public static User toEntity(UserRequest request) {
        if (request == null) {
            return null;
        }
        return new User(
                null,
                request.name(),
                request.adress(),
                request.phone(),
                request.email()
        );
    }

    public static UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getAdress(),
                user.getPhone(),
                user.getEmail()
        );
    }
}

