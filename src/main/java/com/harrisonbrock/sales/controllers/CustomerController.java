package com.harrisonbrock.sales.controllers;

import com.harrisonbrock.sales.models.Customer;
import com.harrisonbrock.sales.repositories.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/custcode/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping()
    public Customer insertOneCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @PutMapping("/custcode/{id}")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable long id) {
        Optional<Customer> customer = repository.findById(id);

        if (customer.isPresent()) {
            updatedCustomer.setCustcode(id);
            repository.save(updatedCustomer);
            return updatedCustomer;
        }
        return null;
    }
}
