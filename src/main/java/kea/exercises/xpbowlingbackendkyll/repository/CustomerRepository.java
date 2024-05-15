package kea.exercises.xpbowlingbackendkyll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<kea.exercises.xpbowlingbackendkyll.model.customer.Customer, Integer> {
}
