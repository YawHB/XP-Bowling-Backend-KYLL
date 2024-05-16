package kea.exercises.xpbowlingbackendkyll.model.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmployeeShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Shift shift;
    @ManyToOne
    private Employee employee;

    public EmployeeShift(Shift shift, Employee employee) {
        this.shift = shift;
        this.employee = employee;
    }
}
