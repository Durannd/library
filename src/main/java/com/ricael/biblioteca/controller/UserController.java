package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.UserRequest;
import com.ricael.biblioteca.controller.response.UserResponse;
import com.ricael.biblioteca.mappers.UserMapper;
import com.ricael.biblioteca.model.User;
import com.ricael.biblioteca.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userServices.findUserById(id));
    }

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) {

        return ResponseEntity.ok(userServices.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userServices.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {

        userServices.updateUser(user, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<UserResponse>> getUsersByNameLike(@RequestParam String name) {
        return ResponseEntity.ok(userServices.getUsersByNameLike(name));
    }
}
