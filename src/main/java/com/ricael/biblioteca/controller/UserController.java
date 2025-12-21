package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.UserRequest;
import com.ricael.biblioteca.mappers.UserMapper;
import com.ricael.biblioteca.model.User;
import com.ricael.biblioteca.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userServices.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping()
    public ResponseEntity<User> createUser(@RequestBody UserRequest user) {

        User savedUser = userServices.saveUser(UserMapper.toEntity(user));
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userServices.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {

        userServices.updateUser(UserMapper.toEntity(user), id);
        return ResponseEntity.ok().build();
    }
}
