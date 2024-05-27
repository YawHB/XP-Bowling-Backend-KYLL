package kea.exercises.xpbowlingbackendkyll.repository;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActivityBookingRepository extends JpaRepository <ActivityBooking, Integer> {

    List<ActivityBooking> findByReservation_ReservationDate(LocalDate reservationDate);
}

