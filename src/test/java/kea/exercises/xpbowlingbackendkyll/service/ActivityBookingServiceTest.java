package kea.exercises.xpbowlingbackendkyll.service;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import kea.exercises.xpbowlingbackendkyll.repository.booking.ActivityBookingRepository;
import kea.exercises.xpbowlingbackendkyll.service.booking.ActivityBookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ActivityBookingServiceTest {

    @InjectMocks
    private ActivityBookingService activityBookingService;

    @Mock
    private ActivityBookingRepository activityBookingRepository;

    private ActivityBooking activityBooking;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        activityBooking = new ActivityBooking(LocalTime.of(10, 0), LocalTime.of(12, 0), 4, null, null);
    }

    @Test
    public void testSaveActivityBooking() {
        when(activityBookingRepository.save(any(ActivityBooking.class))).thenReturn(activityBooking);
        Optional<ActivityBooking> savedActivityBooking = activityBookingService.save(activityBooking);
        assertTrue(savedActivityBooking.isPresent());
        assertEquals(activityBooking, savedActivityBooking.get());
    }

    @Test
    public void testFindAllActivityBookings() {
        when(activityBookingRepository.findAll()).thenReturn(Arrays.asList(activityBooking));
        List<ActivityBooking> activityBookings = activityBookingService.findAll();
        assertEquals(1, activityBookings.size());
        assertEquals(activityBooking, activityBookings.get(0));
    }

    @Test
    public void testFindActivityBookingById() {
        when(activityBookingRepository.findById(any(Integer.class))).thenReturn(Optional.of(activityBooking));
        Optional<ActivityBooking> foundActivityBooking = activityBookingService.findById(1);
        assertTrue(foundActivityBooking.isPresent());
        assertEquals(activityBooking, foundActivityBooking.get());
    }

    @Test
    public void testFindActivityBookingByReservationDate() {
        LocalDate date = LocalDate.now();
        when(activityBookingRepository.findByReservation_ReservationDate(any(LocalDate.class))).thenReturn(Arrays.asList(activityBooking));
        List<ActivityBooking> activityBookings = activityBookingService.findByReservationDate(date);
        assertEquals(1, activityBookings.size());
        assertEquals(activityBooking, activityBookings.get(0));
    }
}

