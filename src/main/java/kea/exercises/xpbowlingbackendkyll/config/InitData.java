package kea.exercises.xpbowlingbackendkyll.config;

import kea.exercises.xpbowlingbackendkyll.enums.Type;
import kea.exercises.xpbowlingbackendkyll.model.activity.Activity;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityParticipants;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import kea.exercises.xpbowlingbackendkyll.model.customer.Customer;
import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import kea.exercises.xpbowlingbackendkyll.repository.*;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Component
@Order(1) // This CommandLineRunner will run first
public class InitData implements CommandLineRunner {

    //H1 Repository injections
    private final ActivityRepository activityRepository;
    private final ActivityTypeRepository activityTypeRepository;
    private final ReservationRepository reservationRepository;
    private final ActivityBookingRepository activityBookingRepository;
    private final CustomerRepository customerRepository;
    private final ActivityParticipantsRepository activityParticipantsRepository;
    private final StockItemRepository stockItemRepository;
    private final ReplacementOrderRepository replacementOrderRepository;
    private final OrderItemRepository orderItemRepository;


    //H1 Constructor InitData with ActivityRepository injection
    public InitData(ActivityRepository activityRepository,
                    ActivityTypeRepository activityTypeRepository,
                    ReservationRepository reservationRepository,
                    ActivityBookingRepository activityBookingRepository,
                    CustomerRepository customerRepository,
                    ActivityParticipantsRepository activityParticipantsRepository,
                    StockItemRepository stockItemRepository,
                    ReplacementOrderRepository replacementOrderRepository,
                    OrderItemRepository orderItemRepository

                   ) {
        this.activityTypeRepository = activityTypeRepository;
        this.reservationRepository = reservationRepository;
        this.activityRepository = activityRepository;
        this.activityBookingRepository = activityBookingRepository;
        this.customerRepository = customerRepository;
        this.activityParticipantsRepository = activityParticipantsRepository;
        this.stockItemRepository = stockItemRepository;
        this.replacementOrderRepository = replacementOrderRepository;
        this.orderItemRepository = orderItemRepository;

    }


    @Override
public void run(String... args) throws Exception {

        createCustomers();
        createReservations();
        createActivityTypes();
        createActivities();
        createActivityBoookings();
        createActivityParticipants();
        createStockItems();
        createReplacementOrders();
        createOrderItems();

        System.out.println("Data has been initialized");

    }

    //h1 Create StockItems
    public void createStockItems() {
        List<StockItem> stockItems = new ArrayList<>(){{

            // for bowling
            add(new StockItem("Bowling-Ball 5 kg", 169, 10));
            add(new StockItem("Bowling-Ball 6 kg", 179, 10));
            add(new StockItem("Bowling-Ball 7 kg", 189, 10));
            add(new StockItem("Bowling-Ball 8 kg", 199, 10));
            add(new StockItem("Bowling-Ball 9 kg", 229, 10));
            add(new StockItem("Bowling-Ball 10 kg", 239, 10));
            add(new StockItem("Bowling-Ball 11 kg", 249, 10));
            add(new StockItem("Bowling-Ball 12 kg", 259, 10));
            add(new StockItem("Bowling-Ball 13 kg", 269, 10));
            add(new StockItem("Bowling-Ball 14 kg", 279, 10));
            add(new StockItem("Bowling-Ball 15 kg", 289, 10));
            add(new StockItem("Bowling-Ball 16 kg", 299, 10));

            add(new StockItem("Bowling-pin", 49, 150));

            add(new StockItem("Bowling-shoe-pair size 30", 99, 5));
            add(new StockItem("Bowling-shoe-pair size 31", 99, 5));
            add(new StockItem("Bowling-shoe-pair size 32", 99, 5));
            add(new StockItem("Bowling-shoe-pair size 33", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 34", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 35", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 36", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 37", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 38", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 39", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 40", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 41", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 42", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 43", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 44", 99, 15));
            add(new StockItem("Bowling-shoe-pair size 45", 99, 5));
            add(new StockItem("Bowling-shoe-pair size 46", 99, 5));
            add(new StockItem("Bowling-shoe-pair size 47", 99, 5));

            // for air-hockey
            add(new StockItem("Air-Hockey table", 2495, 6));
            add(new StockItem("Air-Hockey puck", 29, 9));
            add(new StockItem("Air-Hockey bat", 49, 12));


        }};
        stockItemRepository.saveAll(stockItems);

        // used for shortcut to make 'findByName' method in StockItemRepository
            // StockItem itemName = stockItemRepository.findByName("Bowling-Ball 5 kg");
    }


    //h1 Create ReplacementOrders
    public void createReplacementOrders() {
        List<ReplacementOrder> replacementOrders = new ArrayList<>();

//       replacementOrders.add(new ReplacementOrder("order new bowlingballs for lane 3", 667, LocalDateTime.now()));


        replacementOrders.add(new ReplacementOrder("ordre nye kugler til bane 7",
                2 * stockItemRepository.findByName("Bowling-Ball 8 kg").get().getPrice() + stockItemRepository.findByName("Bowling-Ball 16 kg").get().getPrice(),
                LocalDateTime.now()));

        replacementOrders.add(new ReplacementOrder("ordre nye kugler til bane 8",
                2 * stockItemRepository.findByName("Bowling-Ball 5 kg").get().getPrice() + stockItemRepository.findByName("Bowling-Ball 6 kg").get().getPrice(),
                LocalDateTime.now()));

        replacementOrders.add(new ReplacementOrder("ordre nye kugler til bane 9",
                2 * stockItemRepository.findByName("Bowling-Ball 13 kg").get().getPrice() + stockItemRepository.findByName("Bowling-Ball 16 kg").get().getPrice(),
                LocalDateTime.now()));

        replacementOrderRepository.saveAll(replacementOrders);
    }

    // h1 Create OrderItems
    public void createOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();

        orderItems.add(new OrderItem(2, stockItemRepository.findByName("Bowling-Ball 8 kg").get(), replacementOrderRepository.findById(1).get()));
        orderItems.add(new OrderItem(1, stockItemRepository.findByName("Bowling-Ball 16 kg").get(), replacementOrderRepository.findById(1).get()));

        orderItems.add(new OrderItem(2, stockItemRepository.findByName("Bowling-Ball 5 kg").get(), replacementOrderRepository.findById(2).get()));
        orderItems.add(new OrderItem(1, stockItemRepository.findByName("Bowling-Ball 6 kg").get(), replacementOrderRepository.findById(2).get()));

        orderItems.add(new OrderItem(2, stockItemRepository.findByName("Bowling-Ball 13 kg").get(), replacementOrderRepository.findById(3).get()));
        orderItems.add(new OrderItem(1, stockItemRepository.findByName("Bowling-Ball 16 kg").get(), replacementOrderRepository.findById(3).get()));

        orderItemRepository.saveAll(orderItems);

    };






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
            add(new Reservation(LocalDate.now(), 200, customerRepository.findById(4).get()));
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
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     5, activityRepository.findById(1).get(),
                     reservationRepository.findById(1).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(2),
                     5, activityRepository.findById(24).get(),
                     reservationRepository.findById(1).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     5, activityRepository.findById(25).get(),
                     reservationRepository.findById(1).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     5, activityRepository.findById(31).get(),
                     reservationRepository.findById(1).get()));


             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     2, activityRepository.findById(23).get(),
                     reservationRepository.findById(2).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     2, activityRepository.findById(26).get(),
                     reservationRepository.findById(2).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     2, activityRepository.findById(32).get(),
                     reservationRepository.findById(2).get()));

             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     3, activityRepository.findById(27).get(),
                     reservationRepository.findById(3).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     5, activityRepository.findById(33).get(),
                     reservationRepository.findById(3).get()));

             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     3, activityRepository.findById(11).get(),
                     reservationRepository.findById(4).get()));
             add(new ActivityBooking(showDateWithHour(),  showDateWithHour().plusHours(1),
                     5, activityRepository.findById(22).get(),
                     reservationRepository.findById(4).get()));
         }};
            activityBookingRepository.saveAll(activityBookings);

   }

    public LocalTime showDateWithHour() {
        LocalTime time = LocalTime.of(17, 0);
        return time.withMinute(0).withSecond(0).withNano(0);


    }
}

