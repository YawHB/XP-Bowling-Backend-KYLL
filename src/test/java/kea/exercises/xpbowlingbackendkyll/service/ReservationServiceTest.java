package kea.exercises.xpbowlingbackendkyll.service;


import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import kea.exercises.xpbowlingbackendkyll.repository.booking.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReservationServiceTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testSaveAndFindById() {
        Reservation reservation = new Reservation();
        reservation.setTotalPrice(100.0);
        reservation.setReservationDate(LocalDate.now());

        Reservation savedReservation = reservationRepository.save(reservation);

        assertThat(savedReservation).isNotNull();
        assertThat(savedReservation.getId()).isGreaterThan(0);

        Reservation foundReservation = reservationRepository.findById(savedReservation.getId()).orElse(null);
        assertThat(foundReservation).isNotNull();
        assertThat(foundReservation.getTotalPrice()).isEqualTo(100.0);
    }

    @Test
    public void testFindAll() {
        Reservation reservation1 = new Reservation();
        reservation1.setTotalPrice(100.0);
        reservation1.setReservationDate(LocalDate.now());

        Reservation reservation2 = new Reservation();
        reservation2.setTotalPrice(200.0);
        reservation2.setReservationDate(LocalDate.now().plusDays(1));

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);

        List<Reservation> reservations = reservationRepository.findAll();
        assertThat(reservations).hasSize(2);
    }
}