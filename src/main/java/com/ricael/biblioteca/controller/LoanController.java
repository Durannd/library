package com.ricael.biblioteca.controller;

import com.ricael.biblioteca.controller.request.LoanRequest;
import com.ricael.biblioteca.controller.response.LoanResponse;
import com.ricael.biblioteca.services.LoanServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanServices loanServices;

    @Operation(description = "Search loans by book ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Loans retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No loans found for the given book ID")
    })
    @GetMapping("/by-book/{id}")
    public ResponseEntity<List<LoanResponse>> byBookId(@PathVariable Long id) {
        return ResponseEntity.ok(loanServices.getLoansByBookId(id));
    }

    @Operation(description = "Search loans by user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Loans retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No loans found for the given user ID")
    })
    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<LoanResponse>> byUserId(@PathVariable Long id) {
        return ResponseEntity.ok(loanServices.getLoansByUserId(id));
    }

    @Operation(description = "Delete loans by book ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successfully"),
            @ApiResponse(responseCode = "404", description = "No loans found for the given book ID")
    })
    @DeleteMapping("/by-book/{id}")
    public ResponseEntity<String> deleteByBookId(@PathVariable Long id) {
        loanServices.deleteLoansByBookId(id);
        return ResponseEntity.ok("Deleted loans for book id: " + id);
    }


    @Operation(description = "Insert a new loan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created loan"),
    })
    @PostMapping
    public ResponseEntity<LoanResponse> saveLoan(@RequestBody LoanRequest loan) {
        return ResponseEntity.ok(loanServices.saveLoan(loan));
    }

    @Operation(description = "Delete loan by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted loan"),
            @ApiResponse(responseCode = "404", description = "Loan not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id) {
        loanServices.deleteLoan(id);
        return ResponseEntity.ok("Deleted loan with id: " + id);
    }

    @Operation(description = "Update an existing loan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated loan"),
            @ApiResponse(responseCode = "404", description = "Loan not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LoanResponse> updateLoan(@RequestBody LoanRequest loan, @PathVariable Long id) {
        return ResponseEntity.ok(loanServices.updateLoan(loan, id));
    }

    @Operation(description = "Get loan by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved loan"),
            @ApiResponse(responseCode = "404", description = "Loan not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> getLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(loanServices.getById(id));
    }


}
