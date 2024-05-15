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
        List<ActivityType> activityTypes = new ArrayList<>() {{
            add(new ActivityType(Type.BOWLING_ADULT, 200.00, 6, new ArrayList<>()));
            add(new ActivityType(Type.BOWLING_CHILD, 150.00, 6, new ArrayList<>()));
            add(new ActivityType(Type.AIR_HOCKEY, 100.00, 4, new ArrayList<>()));
            add(new ActivityType(Type.RESTAURANT, 0.00, 0, new ArrayList<>()));
        }};
        activityTypeRepository.saveAll(activityTypes);
    }

    //TODO: Create ActivityBookings
     /*public void createActivityBookings() {
        activityBookingRepository.saveAll(activityBookings);
   }

     */




    //TODO: Create Activities
    public void createActivities() {
        List<Activity> activities  = new ArrayList<>(){{
            add(new Activity());
        }};
        activityRepository.saveAll(activities);
        }










    /*List<OrderLine> orderLines = new ArrayList<>() {{
        add(new OrderLine(product1, 7));
        add(new OrderLine(product2, 10));
        add(new OrderLine(product3, 5));
        add(new OrderLine(product4, 5));
        add(new OrderLine(product5, 5));
        add(new OrderLine(product4, 5));
        add(new OrderLine(product5, 5));
    }};
        orderLineRepository.saveAll(orderLines);

     */

}

