package kea.exercises.xpbowlingbackendkyll.controller;

import kea.exercises.xpbowlingbackendkyll.model.customer.Customer;
import kea.exercises.xpbowlingbackendkyll.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();

    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.findById(id);
    }
}