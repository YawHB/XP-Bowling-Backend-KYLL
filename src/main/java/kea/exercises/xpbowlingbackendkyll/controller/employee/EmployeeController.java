package kea.exercises.xpbowlingbackendkyll.controller.employee;


import kea.exercises.xpbowlingbackendkyll.model.employee.Employee;
import kea.exercises.xpbowlingbackendkyll.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


}
