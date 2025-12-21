package com.ricael.biblioteca.services;

import com.ricael.biblioteca.controller.request.UserRequest;
import com.ricael.biblioteca.controller.response.UserResponse;
import com.ricael.biblioteca.mappers.UserMapper;
import com.ricael.biblioteca.model.User;
import com.ricael.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void deleteUserById(Long id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public UserResponse saveUser(UserRequest user) {
        return UserMapper.toResponse(userRepository.save(UserMapper.toEntity(user)));
    }

    public UserResponse findUserById(Long id) {
        return UserMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(UserRequest user, Long id) {
        if (userRepository.existsById(id)) {
            User u = UserMapper.toEntity(user);
            u.setId(id);
            return UserMapper.toResponse(userRepository.save(u));
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public List<UserResponse> getUsersByNameLike(String name) {
        return userRepository.findByNameContainingIgnoreCase(name).stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
