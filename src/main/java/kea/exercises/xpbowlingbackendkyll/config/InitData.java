package kea.exercises.xpbowlingbackendkyll.config;

import kea.exercises.xpbowlingbackendkyll.enums.Type;
import kea.exercises.xpbowlingbackendkyll.model.activity.Activity;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import kea.exercises.xpbowlingbackendkyll.repository.ActivityRepository;
import kea.exercises.xpbowlingbackendkyll.repository.ActivityTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InitData implements CommandLineRunner {

    //H1 Repository injections
    private final ActivityRepository activityRepository;
    private final ActivityTypeRepository activityTypeRepository;

    //H1 Constructor InitData with ActivityRepository injection
    public InitData(ActivityRepository activityRepository,
                    ActivityTypeRepository activityTypeRepository) {
        this.activityRepository = activityRepository;
        this.activityTypeRepository = activityTypeRepository;
    }


    @Override
public void run(String... args) throws Exception {
        createActivityTypes();
        //createActivityBoookings();
        createActivities();

    }



    //TODO: Create ActivityTypes
    public void createActivityTypes() {
        List<ActivityType> activityTypes = new ArrayList<>(){{
            add(new ActivityType(Type.BOWLING_ADULT, 100, 10));
            add(new ActivityType(Type.BOWLING_CHILD, 50, 5));
            add(new ActivityType(Type.RESTAURANT, 25, 2));
        }};
        activityTypeRepository.saveAll(activityTypes);

    }




    //TODO: Create Activities
    public void createActivities() {
List<Activity> activities = new ArrayList<>(){{
            //h1 Bowling Adult
            add(new Activity("Bowlingbane 1", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 2", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 3", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 4", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 5", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 6", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 7", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 8", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 9", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 10", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 11", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 12", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 13", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 14", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 15", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 16", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 17", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 18", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 19", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingbane 20", activityTypeRepository.findById(1).get()));

            //h1 Bowling Children
            add(new Activity("Bowlingbane 21", activityTypeRepository.findById(2).get()));
            add(new Activity("Bowlingbane 22", activityTypeRepository.findById(2).get()));
            add(new Activity("Bowlingbane 23", activityTypeRepository.findById(2).get()));
            add(new Activity("Bowlingbane 24", activityTypeRepository.findById(2).get()));

            //h1 Airhockey
            add(new Activity("Airhockeybord 1", activityTypeRepository.findById(3).get()));
            add(new Activity("Airhockeybord 2", activityTypeRepository.findById(3).get()));
            add(new Activity("Airhockeybord 3", activityTypeRepository.findById(3).get()));
            add(new Activity("Airhockeybord 4", activityTypeRepository.findById(3).get()));
            add(new Activity("Airhockeybord 5", activityTypeRepository.findById(3).get()));
            add(new Activity("Airhockeybord 6", activityTypeRepository.findById(3).get()));

            //h1 Restaurant
            add(new Activity("Restaurant", activityTypeRepository.findById(4).get()));
        }};
        activityRepository.saveAll(activities);

        }




    //TODO: Create ActivityBookings
     /*public void createActivityBookings() {
        activityBookingRepository.saveAll(activityBookings);
   }

     */



}

