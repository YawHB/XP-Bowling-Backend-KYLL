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


    public ShiftResponseDTO toResponseDTO(Shift shift) {
        ShiftResponseDTO shiftResponseDTO = new ShiftResponseDTO();
        shiftResponseDTO.setDate(shift.getDate());
        shiftResponseDTO.setStartTime(shift.getStartTime());
        shiftResponseDTO.setPlaceName(shift.getPlaceName());
        shiftResponseDTO.setEmployee(shift.getEmployee());
        return shiftResponseDTO;
    }

    public Shift toShift(ShiftRequestDTO shiftRequestDTO) {
        Shift shift = new Shift();
        shift.setDate(shiftRequestDTO.date());
        shift.setStartTime(shiftRequestDTO.startTime());
        shift.setPlaceName(shiftRequestDTO.placeName());
        shift.setEmployee(shiftRequestDTO.employee());
        return shift;
    }


}
