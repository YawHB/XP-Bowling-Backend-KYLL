package kea.exercises.xpbowlingbackendkyll.controller.booking;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.service.booking.ActivityBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ActivityBookingController {
    private final ActivityBookingService activityBookingService;

    public ActivityBookingController(ActivityBookingService activityBookingService){
        this.activityBookingService = activityBookingService;
    }

    @PostMapping("/activityBookings")
    public Optional<ActivityBooking> createCustomer(@RequestBody ActivityBooking activityBooking){
        Optional<ActivityBooking> newActivityBooking = activityBookingService.save(activityBooking);
        return newActivityBooking; }

    @GetMapping("/activityBookings")
    public List<ActivityBooking> getAllCustomers() {
        return activityBookingService.findAll();
    }

    @GetMapping("/activitybookings/reservation/reservationdate/{date}")
    public ResponseEntity<List<ActivityBooking>> getBookingsByDate(@PathVariable String date) {
        List<ActivityBooking> bookings = activityBookingService.findByReservationDate(LocalDate.parse(date) );
        if(bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bookings);
        }
    }

    @GetMapping("/activityBookings/{id}")
    public Optional<ActivityBooking> getCustomerById(@PathVariable int id) {
        return activityBookingService.findById(id);
    }


}
