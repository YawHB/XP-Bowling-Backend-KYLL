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
  @ManyToOne
  private ActivityType activityType;
/*
  @ManyToOne( )
  @JoinColumn(name = "activity_id")
    private ActivityBooking activityBooking;

  @ManyToOne()
  private ActivityType activityType;
*/

    public Activity(String activityName, ActivityType activityType) {
        this.activityName = activityName;
        this.activityType = activityType;
    }
}
