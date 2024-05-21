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

    public EmployeeRole(EmployeeRoleEnum employeeRole) {
        this.employeeRole = employeeRole;
    }
}
