package kea.exercises.xpbowlingbackendkyll.config;

import kea.exercises.xpbowlingbackendkyll.enums.Type;
import kea.exercises.xpbowlingbackendkyll.model.activity.Activity;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityParticipants;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import kea.exercises.xpbowlingbackendkyll.model.customer.Customer;
import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import kea.exercises.xpbowlingbackendkyll.repository.*;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class InitData implements CommandLineRunner {

    //H1 Repository injections
    private final ActivityRepository activityRepository;
    private final ActivityTypeRepository activityTypeRepository;
    private final ReservationRepository reservationRepository;
    private final ActivityBookingRepository activityBookingRepository;
    private final CustomerRepository customerRepository;
    private final ActivityParticipantsRepository activityParticipantsRepository;


    //H1 Constructor InitData with ActivityRepository injection
    public InitData(ActivityRepository activityRepository,
                    ActivityTypeRepository activityTypeRepository,
                    ReservationRepository reservationRepository,
                    ActivityBookingRepository activityBookingRepository,
                    CustomerRepository customerRepository,
                    ActivityParticipantsRepository activityParticipantsRepository

                   ) {
        this.activityTypeRepository = activityTypeRepository;
        this.reservationRepository = reservationRepository;
        this.activityRepository = activityRepository;
        this.activityBookingRepository = activityBookingRepository;
        this.customerRepository = customerRepository;
        this.activityParticipantsRepository = activityParticipantsRepository;

    }


    @Override
public void run(String... args) throws Exception {
        createCustomers();
        createReservations();
        createActivityTypes();
        createActivities();
        createActivityBoookings();
        createActivityParticipants();

    }


    //h1 Create ActivityParticipants
    public void createActivityParticipants() {
        List<ActivityParticipants> activityParticipants = new ArrayList<>(){{
            add(new ActivityParticipants("Kasper Madsen", activityBookingRepository.findById(1).get()));
            add(new ActivityParticipants("Karin Madsen", activityBookingRepository.findById(1).get()));
            add(new ActivityParticipants("Jens Madsen", activityBookingRepository.findById(1).get()));
            add(new ActivityParticipants("Lone Madsen", activityBookingRepository.findById(1).get()));
            add(new ActivityParticipants("Hanne Madsen", activityBookingRepository.findById(1).get()));


            add(new ActivityParticipants("Jens Mogensen", activityBookingRepository.findById(2).get()));
            add(new ActivityParticipants("Lis Hansen", activityBookingRepository.findById(3).get()));
            add(new ActivityParticipants("Karen Jespersen", activityBookingRepository.findById(4).get()));
            add(new ActivityParticipants("Kasper Madsen", activityBookingRepository.findById(5).get()));
            add(new ActivityParticipants("Jens Mogensen", activityBookingRepository.findById(6).get()));
        }};
        activityParticipantsRepository.saveAll(activityParticipants);

    }



    //h1 Create Customers
    public void createCustomers() {
       List<Customer> customers = new ArrayList<>(){{
           add(new Customer("Kasper Madsen", "23344567"));
           add(new Customer("Jens Mogensen", "43891254"));
           add(new Customer("Lis Hansen", "54918456"));
           add(new Customer("Karen Jespersen", "21235399"));
    }};
         customerRepository.saveAll(customers);

    }


    //h1 Create Reservations
    public void createReservations() {
        List<Reservation> reservations = new ArrayList<>(){{
            add(new Reservation(LocalDate.now(), 400, customerRepository.findById(1).get()));
            add(new Reservation(LocalDate.now(), 700, customerRepository.findById(2).get()));
            add(new Reservation(LocalDate.now(), 200, customerRepository.findById(3).get()));
        }};
        reservationRepository.saveAll(reservations);


    }




    //h1 Create ActivityTypes
    public void createActivityTypes() {
        List<ActivityType> activityTypes = new ArrayList<>(){{
            add(new ActivityType(Type.BOWLING_ADULT, 199, 6));
            add(new ActivityType(Type.BOWLING_CHILD, 179, 6));
            add(new ActivityType(Type.AIR_HOCKEY, 149, 6));
            add(new ActivityType(Type.RESTAURANT,0 , 6));
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
            add(new Activity("Bord 1", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 2", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 3", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 4", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 5", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 6", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 7", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 8", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 9", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 10", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 11", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 12", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 13", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 14", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 15", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 16", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 17", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 18", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 19", activityTypeRepository.findById(4).get()));
            add(new Activity("Bord 20", activityTypeRepository.findById(4).get()));
        }};
        activityRepository.saveAll(activities);

        }

     //h1: Create ActivityBookings
     public void createActivityBoookings() {
         List<ActivityBooking> activityBookings = new ArrayList<>(){{
             add(new ActivityBooking(LocalDate.now(), LocalDate.now(),
                     5, activityRepository.findById(1).get(),
                     reservationRepository.findById(1).get()));
             add(new ActivityBooking(LocalDate.now(), LocalDate.now(),
                     2, activityRepository.findById(2).get(),
                     reservationRepository.findById(2).get()));
             add(new ActivityBooking(LocalDate.now(), LocalDate.now(),
                     2, activityRepository.findById(2).get(),
                     reservationRepository.findById(2).get()));
             add(new ActivityBooking(LocalDate.now(), LocalDate.now(),
                     2, activityRepository.findById(3).get(),
                     reservationRepository.findById(2).get()));
             add(new ActivityBooking(LocalDate.now(), LocalDate.now(),
                     3, activityRepository.findById(1).get(),
                     reservationRepository.findById(3).get()));
             add(new ActivityBooking(LocalDate.now(), LocalDate.now(),
                     5, activityRepository.findById(4).get(),
                     reservationRepository.findById(3).get()));
         }};
            activityBookingRepository.saveAll(activityBookings);

   }

}

