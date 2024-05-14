package kea.exercises.xpbowlingbackendkyll.model.employee;

import jakarta.persistence.*;
import kea.exercises.xpbowlingbackendkyll.enums.EmployeeRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
//EmployeeRoleEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmployeeRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private EmployeeRoleEnum employeeRole;
    @OneToMany
    @JoinColumn(name = "employee_role_id")
    private List<Employee> employees;


    public EmployeeRole(EmployeeRoleEnum employeeRole, List<Employee> employees) {
        this.employeeRole = employeeRole;
        this.employees = employees;
    }
}
