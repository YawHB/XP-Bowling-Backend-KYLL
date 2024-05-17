package kea.exercises.xpbowlingbackendkyll.repository;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityBookingRepository extends JpaRepository <ActivityBooking, Integer> {

}
