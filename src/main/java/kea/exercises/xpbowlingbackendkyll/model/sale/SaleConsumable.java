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
    private int amount;

    @ManyToOne
    private Sale sale;

    @ManyToOne
    private Consumable consumable;

    public SaleConsumable(int amount, Sale sale, Consumable consumable) {
        this.amount = amount;
        this.sale = sale;
        this.consumable = consumable;
    }
}