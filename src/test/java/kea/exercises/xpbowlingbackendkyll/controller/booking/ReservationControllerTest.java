package kea.exercises.xpbowlingbackendkyll.controller.booking;

import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import kea.exercises.xpbowlingbackendkyll.repository.booking.ReservationRepository;
import kea.exercises.xpbowlingbackendkyll.service.booking.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Reservation reservation = new Reservation();
        reservation.setTotalPrice(100.0);
        reservation.setReservationDate(LocalDate.now());

        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Optional<Reservation> savedReservation = reservationService.save(reservation);

        assertThat(savedReservation).isPresent();
        assertThat(savedReservation.get().getTotalPrice()).isEqualTo(100.0);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testFindById() {
        Reservation reservation = new Reservation();
        reservation.setTotalPrice(100.0);
        reservation.setReservationDate(LocalDate.now());

        when(reservationRepository.findById(anyInt())).thenReturn(Optional.of(reservation));

        Optional<Reservation> foundReservation = reservationService.findById(1);

        assertThat(foundReservation).isPresent();
        assertThat(foundReservation.get().getTotalPrice()).isEqualTo(100.0);
        verify(reservationRepository, times(1)).findById(1);
    }

    @Test
    public void testUpdateReservation() {
        Reservation existingReservation = new Reservation();
        existingReservation.setTotalPrice(100.0);
        existingReservation.setReservationDate(LocalDate.now());

        Reservation updatedReservation = new Reservation();
        updatedReservation.setTotalPrice(150.0);
        updatedReservation.setReservationDate(LocalDate.now().plusDays(1));

        when(reservationRepository.findById(anyInt())).thenReturn(Optional.of(existingReservation));
        when(reservationRepository.save(any(Reservation.class))).thenReturn(existingReservation);

        Optional<Reservation> result = reservationService.updateReservation(1, updatedReservation);

        assertThat(result).isPresent();
        assertThat(result.get().getTotalPrice()).isEqualTo(150.0);
        assertThat(result.get().getReservationDate()).isEqualTo(LocalDate.now().plusDays(1));
        verify(reservationRepository, times(1)).findById(1);
        verify(reservationRepository, times(1)).save(existingReservation);
    }
}