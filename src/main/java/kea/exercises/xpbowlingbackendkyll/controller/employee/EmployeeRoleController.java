package kea.exercises.xpbowlingbackendkyll.controller.employee;

import kea.exercises.xpbowlingbackendkyll.model.employee.EmployeeRole;
import kea.exercises.xpbowlingbackendkyll.service.employee.EmployeeRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeRoleController {

    private final EmployeeRoleService employeeRoleService;

    public EmployeeRoleController(EmployeeRoleService employeeRoleService) {
        this.employeeRoleService = employeeRoleService;
    }



    // Get all employee roles
    @GetMapping("/employeeroles")
    public List<EmployeeRole> getEmployeeRoles() {
        return employeeRoleService.getEmployeeRoles();
    }
}
