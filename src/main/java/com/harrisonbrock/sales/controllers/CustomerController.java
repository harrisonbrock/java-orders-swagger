package com.harrisonbrock.sales.controllers;

import com.harrisonbrock.sales.models.Customer;
import com.harrisonbrock.sales.repositories.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
