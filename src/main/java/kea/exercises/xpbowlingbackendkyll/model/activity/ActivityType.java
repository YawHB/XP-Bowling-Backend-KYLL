package kea.exercises.xpbowlingbackendkyll.model.activity;
import jakarta.persistence.*;
import kea.exercises.xpbowlingbackendkyll.enums.Type;
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

    public ActivityType(Type type, double hourlyPrice, int maxCapacity) {
        this.type = type;
        this.hourlyPrice = hourlyPrice;
        this.maxCapacity = maxCapacity;
    }
}


