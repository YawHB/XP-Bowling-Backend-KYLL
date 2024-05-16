package kea.exercises.xpbowlingbackendkyll.model.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private double totalPrice;
    private LocalDateTime orderTime;
    @ManyToOne
    private StockItem stockItem;
    @ManyToOne
    private ReplacementOrder replacementOrder;

    public OrderItem(int id, double amount, double totalPrice, LocalDateTime orderTime, StockItem stockItem, ReplacementOrder replacementOrder) {
        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
        this.stockItem = stockItem;
        this.replacementOrder = replacementOrder;
    }
}
