package kea.exercises.xpbowlingbackendkyll.controller.employee;

import kea.exercises.xpbowlingbackendkyll.model.employee.Shift;
import kea.exercises.xpbowlingbackendkyll.service.employee.ShiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShiftController {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping("/shifts")
    public List<Shift> getShifts() {
        return shiftService.getShifts();
    }

    @GetMapping("/shifts/{id}")
    public Optional<Shift> getShiftById(@PathVariable int id) {
        return shiftService.getShiftById(id);
    }

    @PostMapping("/shifts")
    public Shift addShift(@RequestBody Shift shift) {
        return shiftService.addShift(shift);
    }
}