package kea.exercises.xpbowlingbackendkyll.dtos;

import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import java.util.List;

public record ReplacementOrderRequestDTO(ReplacementOrder replacementOrder, List<OrderItemRequestDTO> orderItems) {
}
