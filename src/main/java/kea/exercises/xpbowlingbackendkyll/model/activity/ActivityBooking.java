package kea.exercises.xpbowlingbackendkyll.model.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class ActivityBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startTime;
    private LocalDate endTime;
    @OneToMany()
    @JoinColumn(name = "activity_booking_id")
    private List<ActivityParticipants> participants;






}
