package kea.exercises.xpbowlingbackendkyll.model.activity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ActivityBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int reservationId;
    private int Activity;
    private int numberParticipants;
    private LocalDate startTime;
    private LocalDate endTime;

}
