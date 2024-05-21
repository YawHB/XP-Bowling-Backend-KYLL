package kea.exercises.xpbowlingbackendkyll.model.activity;

import jakarta.persistence.*;
import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ActivityBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private int numberParticipants;
    @ManyToOne
    private Activity activity;
    @ManyToOne
    private Reservation reservation;

    public ActivityBooking(LocalTime startTime, LocalTime endTime, int numberParticipants, Activity activity, Reservation reservation) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberParticipants = numberParticipants;
        this.activity = activity;
        this.reservation = reservation;
    }
}
