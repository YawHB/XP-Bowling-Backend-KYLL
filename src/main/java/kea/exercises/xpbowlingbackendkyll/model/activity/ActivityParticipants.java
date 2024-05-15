package kea.exercises.xpbowlingbackendkyll.model.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ActivityParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private ActivityBooking activityBooking;

    public ActivityParticipants(String name, ActivityBooking activityBooking) {
        this.name = name;
        this.activityBooking = activityBooking;
    }
}
