package kea.exercises.xpbowlingbackendkyll.model.sale;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp saleDate;

    private double totalPrice;
    @OneToMany
    @JoinColumn(name = "sale_id")
    private List<SaleConsumable> saleConsumables;

}
