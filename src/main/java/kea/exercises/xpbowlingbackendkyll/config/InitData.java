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

    //TODO: Create ActivityBookings
     /*public void createActivityBookings() {
        activityBookingRepository.saveAll(activityBookings);
   }

     */




    //TODO: Create Activities
    public void createActivities() {
List<Activity> activities = new ArrayList<>(){{
            //h1 Bowling Adult
            add(new Activity("Bowlingbane 1", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 2", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 3", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 4", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 5", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 6", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 7", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 8", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 9", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 10", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 11", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 12", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 13", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 14", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 15", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 16", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 17", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 18", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 19", activityTypeRepository.findById(1).get()));
            add(new Activity("Bowlingban 20", activityTypeRepository.findById(1).get()));

            //h1 Bowling Children
            add(new Activity("Bowlingban 21", activityTypeRepository.findById(2).get()));
            add(new Activity("Bowlingban 22", activityTypeRepository.findById(2).get()));
            add(new Activity("Bowlingban 23", activityTypeRepository.findById(2).get()));
            add(new Activity("Bowlingban 24", activityTypeRepository.findById(2).get()));

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

