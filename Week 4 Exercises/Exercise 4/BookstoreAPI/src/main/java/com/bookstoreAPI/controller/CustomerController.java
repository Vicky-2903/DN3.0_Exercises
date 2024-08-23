package com.bookstoreAPI.controller;

import com.bookstoreAPI.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    // Endpoint to handle JSON request body
    @PostMapping("/json")
    public ResponseEntity<String> createCustomerFromJson(@RequestBody Customer customer) {
        // Here you would typically save the customer to a database
        // For now, we just return a success message
        return ResponseEntity.ok("Customer created with JSON data: " + customer);
    }

    // Endpoint to handle form data
    @PostMapping("/form")
    public ResponseEntity<String> createCustomerFromForm(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String password) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        // Here you would typically save the customer to a database
        // For now, we just return a success message
        return ResponseEntity.ok("Customer created with form data: " + customer);
    }
}
