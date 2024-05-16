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

    public Sale(int id, Timestamp saleDate, double totalPrice) {
        this.id = id;
        this.saleDate = saleDate;
        this.totalPrice = totalPrice;
    }
}
