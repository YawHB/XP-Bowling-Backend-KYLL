package kea.exercises.xpbowlingbackendkyll.model.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Employee employee;
    private LocalDate date;
    private int startTime;
    private String placeName;

    public Shift(Employee employee, LocalDate date, int startTime, String placeName) {
        this.employee = employee;
        this.date = date;
        this.startTime = startTime;
        this.placeName = placeName;
    }
}
