package kea.exercises.xpbowlingbackendkyll.model.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ReplacementOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String title;
    private double price;

    public ReplacementOrder(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
