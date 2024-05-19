package kea.exercises.xpbowlingbackendkyll.model.sale;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Consumable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Setter
    private double price;

    public Consumable(String title, double price) {
        this.title = title;
        this.price = price;
    }

}