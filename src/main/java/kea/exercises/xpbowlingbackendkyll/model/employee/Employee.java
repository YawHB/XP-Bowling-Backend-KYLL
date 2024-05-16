package kea.exercises.xpbowlingbackendkyll.model.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private EmployeeRole employeeRole;

    public Employee(int id, String firstName, String lastName, EmployeeRole employeeRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeRole = employeeRole;
    }
}
