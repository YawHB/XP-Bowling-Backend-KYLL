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
    @OneToMany
    @JoinColumn(name = "consumable_id")
    private List<SaleConsumable> saleConsumables;


}
