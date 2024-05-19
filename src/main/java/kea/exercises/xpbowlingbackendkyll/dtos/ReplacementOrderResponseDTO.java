package kea.exercises.xpbowlingbackendkyll.dtos;

import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;

import java.util.List;

public record ReplacementOrderResponseDTO(ReplacementOrder replacementOrder, List<OrderItemResponseDTO> orderItems) {
}
