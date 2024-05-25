package kea.exercises.xpbowlingbackendkyll.service.employee;

import kea.exercises.xpbowlingbackendkyll.model.employee.Employee;
import kea.exercises.xpbowlingbackendkyll.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
