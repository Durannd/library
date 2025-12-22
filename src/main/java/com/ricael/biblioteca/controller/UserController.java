package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.UserRequest;
import com.ricael.biblioteca.controller.response.UserResponse;
import com.ricael.biblioteca.mappers.UserMapper;
import com.ricael.biblioteca.model.User;
import com.ricael.biblioteca.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @Operation(description = "Get a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userServices.findUserById(id));
    }

    @Operation(description = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
    })
    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) {

        return ResponseEntity.ok(userServices.saveUser(user));
    }

    @Operation(description = "Delete a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userServices.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @Operation(description = "Update a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {

        userServices.updateUser(user, id);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "Get all users")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }

    @Operation(description = "Get users by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No users found with the given name")
    })
    @GetMapping("/by-name")
    public ResponseEntity<List<UserResponse>> getUsersByNameLike(@RequestParam String name) {
        return ResponseEntity.ok(userServices.getUsersByNameLike(name));
    }
}
