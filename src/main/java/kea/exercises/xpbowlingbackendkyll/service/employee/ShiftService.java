package kea.exercises.xpbowlingbackendkyll.service.employee;

import kea.exercises.xpbowlingbackendkyll.model.employee.Shift;
import kea.exercises.xpbowlingbackendkyll.repository.employee.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {

    //private repository
    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public List<Shift> getShifts() {
        return shiftRepository.findAll();
    }

    public Shift addShift(Shift shift) {
            return shiftRepository.save(shift);
    }

    public Optional<Shift> getShiftById(int id) {
        return shiftRepository.findById(id);
    }
}
