package kea.exercises.xpbowlingbackendkyll.controller;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.service.ActivityBookingService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/activityBookings/{id}")
    public Optional<ActivityBooking> getCustomerById(@PathVariable int id) {
        return activityBookingService.findById(id);
    }


}
