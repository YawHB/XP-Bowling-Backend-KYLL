package kea.exercises.xpbowlingbackendkyll.dtos;


//public record OrderItemRequestDTO(int amountToOrder, StockItemRequestDTO stockItem) {
//}

public class OrderItemRequestDTO {
    private int amountToOrder;
    private StockItemRequestDTO stockItem;

    // getters and setters
    public int getAmountToOrder() {
        return amountToOrder;
    }

    public void setAmountToOrder(int amountToOrder) {
        this.amountToOrder = amountToOrder;
    }

    public StockItemRequestDTO getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItemRequestDTO stockItem) {
        this.stockItem = stockItem;
    }
}