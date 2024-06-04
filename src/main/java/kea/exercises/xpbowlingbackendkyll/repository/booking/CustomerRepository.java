package kea.exercises.xpbowlingbackendkyll.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import kea.exercises.xpbowlingbackendkyll.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
