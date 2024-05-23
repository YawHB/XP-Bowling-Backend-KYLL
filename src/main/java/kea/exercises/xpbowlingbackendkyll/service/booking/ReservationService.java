package kea.exercises.xpbowlingbackendkyll.service.booking;

import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import kea.exercises.xpbowlingbackendkyll.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    public final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    public Optional<Reservation> save(Reservation reservation) {
        Reservation savedReservation = reservationRepository.save(reservation);
        return Optional.of(savedReservation);
    }
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(int id) {
        return reservationRepository.findById(id);
    }

    public Optional<Reservation> updateReservation(int id, Reservation updatedReservation) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setTotalPrice(updatedReservation.getTotalPrice()); // update specific fields
            reservation.setReservationDate(updatedReservation.getReservationDate());
            reservationRepository.save(reservation);
            return reservation;
        });
    }


}

