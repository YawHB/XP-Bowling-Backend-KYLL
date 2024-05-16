package kea.exercises.xpbowlingbackendkyll.model.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public OrderItem(double amount, double totalPrice, LocalDateTime orderTime, StockItem stockItem, ReplacementOrder replacementOrder) {
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
        this.stockItem = stockItem;
        this.replacementOrder = replacementOrder;
    }
}
