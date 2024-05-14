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
    @OneToMany
    @JoinColumn(name = "order_item_id")
    private List<OrderItem> orderItems;



}
