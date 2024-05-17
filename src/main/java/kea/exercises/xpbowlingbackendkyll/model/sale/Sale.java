package kea.exercises.xpbowlingbackendkyll.model.sale;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp saleDate;
    private double totalPrice;

    @ManyToMany
    @JoinTable(name = "sale_consumables",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "consumable_id"))
    private List<Consumable> consumables;

    public Sale(Timestamp saleDate, double totalPrice) {
        this.saleDate = saleDate;
        this.totalPrice = totalPrice;
    }
}