package kea.exercises.xpbowlingbackendkyll.model.sale;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SaleConsumable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private double bundlePrice;
    @ManyToOne
    private Sale sale;
    @ManyToOne
    private Consumable consumable;

    public SaleConsumable(int id, double amount, double bundlePrice, Sale sale, Consumable consumable) {
        this.id = id;
        this.amount = amount;
        this.bundlePrice = bundlePrice;
        this.sale = sale;
        this.consumable = consumable;
    }
}
