package kea.exercises.xpbowlingbackendkyll.model.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double amount;

    public StockItem(int id, String title, double amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }
}
