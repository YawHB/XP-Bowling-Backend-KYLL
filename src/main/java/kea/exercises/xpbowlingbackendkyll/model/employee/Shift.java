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
    private LocalDate date;
    private int startTime;
    private String placeName;
    @ManyToOne
    private Employee employee;

    public Shift(LocalDate date, int startTime, String placeName, Employee employee) {
        this.date = date;
        this.startTime = startTime;
        this.placeName = placeName;
        this.employee = employee;
    }
}
