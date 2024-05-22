package kea.exercises.xpbowlingbackendkyll.dtos.employeedtos;

import kea.exercises.xpbowlingbackendkyll.model.employee.Employee;
import java.time.LocalDate;

public record ShiftRequestDTO(
        int id,
        LocalDate date,
        int startTime,
        String placeName,
        Employee employee
) {
}
