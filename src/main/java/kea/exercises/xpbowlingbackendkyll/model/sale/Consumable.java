package kea.exercises.xpbowlingbackendkyll.model.sale;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Consumable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double price;

    public Consumable(String title, int id, double price) {
        this.title = title;
        this.id = id;
        this.price = price;
    }
}
