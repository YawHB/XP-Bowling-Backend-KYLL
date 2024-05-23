package kea.exercises.xpbowlingbackendkyll.controller.booking;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import kea.exercises.xpbowlingbackendkyll.service.booking.ActivityTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService){
        this.activityTypeService = activityTypeService;
    }


    @GetMapping("/activityTypes")
    public List<ActivityType> getAllActivityTypes(){
        return activityTypeService.findAll();
    }

    @GetMapping("/activityTypes/{id}")
public Optional<ActivityType> getActivityTypeById(@PathVariable int id){
        return activityTypeService.findById(id);
    }


}
