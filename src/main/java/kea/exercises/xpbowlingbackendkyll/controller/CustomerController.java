package kea.exercises.xpbowlingbackendkyll.controller;

import kea.exercises.xpbowlingbackendkyll.model.customer.Customer;
import kea.exercises.xpbowlingbackendkyll.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.save(customer)) ; }



    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.findById(id);
    }




}