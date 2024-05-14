package kea.exercises.xpbowlingbackendkyll.config;

import kea.exercises.xpbowlingbackendkyll.model.activity.Activity;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import kea.exercises.xpbowlingbackendkyll.repository.ActivityRepository;
import kea.exercises.xpbowlingbackendkyll.repository.ActivityTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InitData implements CommandLineRunner {

    //Repository injections :D
    private final ActivityRepository activityRepository;
    private final ActivityTypeRepository activityTypeRepository;

    //TODO Constructor InitData with ActivityRepository injection
    public InitData(ActivityRepository activityRepository,
                    ActivityTypeRepository activityTypeRepository) {
        this.activityRepository = activityRepository;
        this.activityTypeRepository = activityTypeRepository;
    }


    @Override
public void run(String... args) throws Exception {
    createActivities();

    }



    public void createActivities() {
        //TODO Create activities

    }


    //Create activity types





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
