package kea.exercises.xpbowlingbackendkyll.dtos;


import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;

import java.util.List;

public record ReplacementOrderRequestDTO(ReplacementOrder replacementOrder, List<OrderItem> orderItems) {
//    public ReplacementOrderRequestDTO {
//        if (replacementOrder == null) {
//            throw new IllegalArgumentException("replacementOrder cannot be null");
//        }
//        if (orderItems == null) {
//            throw new IllegalArgumentException("orderItems cannot be null");
//        }
//    }
}
