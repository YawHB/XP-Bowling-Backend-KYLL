package kea.exercises.xpbowlingbackendkyll.service.booking;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.repository.booking.ActivityBookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityBookingService {

    private final ActivityBookingRepository activityBookingRepository;

    public ActivityBookingService(ActivityBookingRepository activityBookingRepository){
        this.activityBookingRepository = activityBookingRepository;
    }
    public Optional<ActivityBooking> save(ActivityBooking activityBooking) {
        ActivityBooking savedActivityBooking = activityBookingRepository.save(activityBooking);
        return Optional.of(savedActivityBooking);
    }
    public List<ActivityBooking> findAll() {
        return activityBookingRepository.findAll();
    }

    public Optional<ActivityBooking> findById(int id) {
        return activityBookingRepository.findById(id);
    }

    public List<ActivityBooking> findByReservationDate(LocalDate date) {
        return activityBookingRepository.findByReservation_ReservationDate(date);
    }
}
