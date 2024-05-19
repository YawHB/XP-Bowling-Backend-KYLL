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
    private double amountToOrder;
    @ManyToOne
    private StockItem stockItem;
    @ManyToOne
    private ReplacementOrder replacementOrder;

    public OrderItem(double amountToOrder, StockItem stockItem, ReplacementOrder replacementOrder) {
        this.amountToOrder = amountToOrder;
        this.stockItem = stockItem;
        this.replacementOrder = replacementOrder;
    }
}
