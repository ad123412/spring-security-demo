package com.ada.secured.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    private List<String> EMPLOYEES = Arrays.asList("Pronab", "Rajib");

    @GetMapping("/employee")
    public List<String> getEmployees() {
        return EMPLOYEES;
    }

    @GetMapping("/employee/{name}")
    public String getEmployee(@PathVariable String name) {
        return EMPLOYEES.stream().filter(emp -> name.equals(emp)).findFirst().orElseGet(() -> "Not Found");
    }
}
