package kea.exercises.xpbowlingbackendkyll.repository.stock;

import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
