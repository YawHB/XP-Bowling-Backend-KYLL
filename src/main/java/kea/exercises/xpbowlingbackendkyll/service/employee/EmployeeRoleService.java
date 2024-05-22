package kea.exercises.xpbowlingbackendkyll.service.employee;

import kea.exercises.xpbowlingbackendkyll.model.employee.EmployeeRole;
import kea.exercises.xpbowlingbackendkyll.repository.employee.EmployeeRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRoleService {

    private final EmployeeRoleRepository employeeRoleRepository;

    public EmployeeRoleService(EmployeeRoleRepository employeeRoleRepository) {
        this.employeeRoleRepository = employeeRoleRepository; }

        public List<EmployeeRole> getEmployeeRoles() {
            return employeeRoleRepository.findAll();
        }

}
