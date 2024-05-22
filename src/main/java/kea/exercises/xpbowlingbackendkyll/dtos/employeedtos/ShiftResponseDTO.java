package kea.exercises.xpbowlingbackendkyll.dtos.employeedtos;

import kea.exercises.xpbowlingbackendkyll.model.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ShiftResponseDTO {

    // Request DTO for creating a new shift with less information
    private int id;
    private LocalDate date;
    private int startTime;
    private String placeName;
    private Employee employee;

    public ShiftResponseDTO(LocalDate date, int startTime, String placeName, Employee employee) {
        this.date = date;
        this.startTime = startTime;
        this.placeName = placeName;
        this.employee = employee;
    }
}
