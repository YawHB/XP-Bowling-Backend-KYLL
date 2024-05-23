package kea.exercises.xpbowlingbackendkyll.controller.booking;



import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityParticipants;
import kea.exercises.xpbowlingbackendkyll.service.booking.ActivityParticipantsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityParticipantsController {

    private final ActivityParticipantsService activityParticipantsService;

    public ActivityParticipantsController(ActivityParticipantsService activityParticipantsService){
        this.activityParticipantsService = activityParticipantsService;
    }


    @PostMapping("/activityParticipants")
    public Optional<ActivityParticipants> createCustomer(@RequestBody ActivityParticipants activityParticipant){
        Optional<ActivityParticipants> newActivityParticipant = activityParticipantsService.save(activityParticipant);
        return newActivityParticipant; }

    @GetMapping("/activityParticipants")
    public List<ActivityParticipants> getAllCustomers() {
        return activityParticipantsService.findAll();
    }

    @GetMapping("/activityParticipants/{id}")
    public Optional<ActivityParticipants> getCustomerById(@PathVariable int id) {
        return activityParticipantsService.findById(id);
    }





}
