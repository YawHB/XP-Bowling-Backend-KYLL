package kea.exercises.xpbowlingbackendkyll.repository.booking;

import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
