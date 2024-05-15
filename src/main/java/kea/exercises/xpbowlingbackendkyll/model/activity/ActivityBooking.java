package kea.exercises.xpbowlingbackendkyll.model.activity;

import jakarta.persistence.*;
import kea.exercises.xpbowlingbackendkyll.model.customer.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ActivityBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startTime;
    private LocalDate endTime;
    private int numberParticipants;
    @ManyToOne
    private Activity activity;
    @ManyToOne
    private Reservation reservation;


}
