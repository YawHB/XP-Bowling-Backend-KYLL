package kea.exercises.xpbowlingbackendkyll.controller;

import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import kea.exercises.xpbowlingbackendkyll.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    // Reservation tager et helt customerObject og ikke kun et ID. ID burder være nok...
    @PostMapping("/reservations")
    public Optional<Reservation> createCustomer(@RequestBody Reservation reservation){
        Optional<Reservation> newReservation = reservationService.save(reservation);
        return newReservation; }

    @GetMapping("/reservations")
    public List<Reservation> getAllCustomers() {
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Optional<Reservation> getCustomerById(@PathVariable int id) {
        return reservationService.findById(id);
    }

    @PatchMapping("/reservations/{id}")
    public Optional<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation);
    }


}
