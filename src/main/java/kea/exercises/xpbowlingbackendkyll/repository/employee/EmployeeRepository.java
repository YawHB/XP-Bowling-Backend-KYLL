package kea.exercises.xpbowlingbackendkyll.repository.employee;

import kea.exercises.xpbowlingbackendkyll.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
