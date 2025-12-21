package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.PublisherResponse;
import com.ricael.biblioteca.mappers.PublisherMapper;
import com.ricael.biblioteca.services.PublisherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherServices publisherServices;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id){
        publisherServices.deletePublisher(id);
        return ResponseEntity.ok("Publisher deleted successfully");
    }

    @PostMapping
    public ResponseEntity<PublisherResponse> createBook(@RequestBody PublisherRequest publisherRequest){
        return ResponseEntity.ok(publisherServices.savePublisher(publisherRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherServices.getPublisher(id));
    }

    @GetMapping
    public ResponseEntity<List<PublisherResponse>> getAllPublishers() {

        return ResponseEntity.ok(publisherServices.getAllPublisher());
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<PublisherResponse>> getAllPublishersByNameLike(@RequestParam String name) {
        return ResponseEntity.ok(publisherServices.getAllPublisherByNameLike(name));
    }
}
