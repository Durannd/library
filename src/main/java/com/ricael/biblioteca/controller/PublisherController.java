package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.PublisherResponse;
import com.ricael.biblioteca.mappers.PublisherMapper;
import com.ricael.biblioteca.services.PublisherServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherServices publisherServices;

    @Operation(description = "Delete a publisher by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publisher deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Publisher not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id){
        publisherServices.deletePublisher(id);
        return ResponseEntity.ok("Publisher deleted successfully");
    }

    @Operation(description = "Create a new publisher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publisher created successfully"),
    })
    @PostMapping
    public ResponseEntity<PublisherResponse> createBook(@RequestBody PublisherRequest publisherRequest){
        return ResponseEntity.ok(publisherServices.savePublisher(publisherRequest));
    }

    @Operation(description = "Get a publisher by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publisher retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Publisher not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherServices.getPublisher(id));
    }

    @Operation(description = "Get all publishers")
    @ApiResponse(responseCode = "200", description = "Publishers retrieved successfully")
    @GetMapping
    public ResponseEntity<List<PublisherResponse>> getAllPublishers() {

        return ResponseEntity.ok(publisherServices.getAllPublisher());
    }

    @Operation(description = "Get publishers by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publishers retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No publishers found with the given name")
    })
    @GetMapping("/by-name")
    public ResponseEntity<List<PublisherResponse>> getAllPublishersByNameLike(@RequestParam String name) {
        return ResponseEntity.ok(publisherServices.getAllPublisherByNameLike(name));
    }
}
