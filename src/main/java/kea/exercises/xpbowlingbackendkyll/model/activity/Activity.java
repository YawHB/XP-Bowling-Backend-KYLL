package kea.exercises.xpbowlingbackendkyll.model.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


  private String activityName;

  @ManyToOne()
  @JoinColumn(name = "activity_id")
    private ActivityBooking activityBooking;


    public Activity(String activityName, ActivityBooking activityBooking) {
        this.activityName = activityName;
        this.activityBooking = activityBooking;
    }
}
