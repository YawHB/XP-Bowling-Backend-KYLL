package kea.exercises.xpbowlingbackendkyll.dtos;

import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;

public record OrderItemResponseDTO(int amountToOrder, StockItem stockItem) {
}
