package kea.exercises.xpbowlingbackendkyll.repository;

import kea.exercises.xpbowlingbackendkyll.model.employee.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
}
