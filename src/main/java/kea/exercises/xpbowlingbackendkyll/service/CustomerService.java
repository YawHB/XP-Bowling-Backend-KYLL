package kea.exercises.xpbowlingbackendkyll.service;

import kea.exercises.xpbowlingbackendkyll.model.customer.Customer;
import kea.exercises.xpbowlingbackendkyll.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public Customer save(Customer customer) {
        return customerRepository.save(customer);

    }
    public List<Customer>  findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }
}
