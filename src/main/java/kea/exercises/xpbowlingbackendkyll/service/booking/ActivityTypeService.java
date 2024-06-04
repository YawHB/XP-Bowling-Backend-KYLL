package kea.exercises.xpbowlingbackendkyll.service.booking;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import kea.exercises.xpbowlingbackendkyll.repository.booking.ActivityTypeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;

    public ActivityTypeService(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    // Get all
    public List<ActivityType> findAll() {return activityTypeRepository.findAll();}

   // Get by id
    public Optional<ActivityType> findById(int id) {return activityTypeRepository.findById(id);}

}
