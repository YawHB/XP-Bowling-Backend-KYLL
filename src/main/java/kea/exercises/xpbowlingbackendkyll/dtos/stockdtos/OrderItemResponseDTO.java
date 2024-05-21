package kea.exercises.xpbowlingbackendkyll.dtos.stockdtos;

import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;

public record OrderItemResponseDTO(int amountToOrder, StockItem stockItem) {
}
