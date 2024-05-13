package kea.exercises.xpbowlingbackendkyll.model.activity;
import jakarta.persistence.*;
import kea.exercises.xpbowlingbackendkyll.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     private Type type;

     private double hourlyPrice;

     private int maxCapacity;

    @OneToMany(mappedBy = "activityTypeId")
     private List<Activity> activities;

}


