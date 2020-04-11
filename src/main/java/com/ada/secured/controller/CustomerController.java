package com.ada.secured.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    private List<String> CUSTOMERS = Arrays.asList("Abhishek", "Rohit");

    @GetMapping("/customer")
    public List<String> getCustomers() {
        return CUSTOMERS;
    }

    @GetMapping("/customer/{name}")
    public String getCustomer(@PathVariable String name) {
        return CUSTOMERS.stream().filter(cust -> name.equals(cust)).findFirst().orElseGet(() -> "Not Found");
    }
}
