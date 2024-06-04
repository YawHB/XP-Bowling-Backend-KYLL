package kea.exercises.xpbowlingbackendkyll.model.stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void getId() {
        // Arrange
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1);

        // Act
        int result = orderItem.getId();

        // Assert
        assertEquals(1, result);

    }

    @Test
    void getAmountToOrder() {

        // Arrange
        OrderItem orderItem = new OrderItem();
        orderItem.setAmountToOrder(1);

        // Act
        int result = orderItem.getAmountToOrder();

        // Assert
        assertEquals(1, result);
    }

    @Test
    void getStockItem() {
        // Arrange
        OrderItem orderItem = new OrderItem();
        StockItem stockItem = new StockItem();
        orderItem.setStockItem(stockItem);

        // Act
        StockItem result = orderItem.getStockItem();

        // Assert
        assertEquals(stockItem, result);
    }

    @Test
    void getReplacementOrder() {
        // Arrange
        OrderItem orderItem = new OrderItem();
        ReplacementOrder replacementOrder = new ReplacementOrder();
        orderItem.setReplacementOrder(replacementOrder);

        // Act
        ReplacementOrder result = orderItem.getReplacementOrder();

        // Assert
        assertEquals(replacementOrder, result);
    }


    @Test
    void setAmountToOrder() {
        // Arrange
        OrderItem orderItem = new OrderItem();

        // Act
        orderItem.setAmountToOrder(1);

        // Assert
        assertEquals(1, orderItem.getAmountToOrder());

    }

    @Test
    void setStockItem() {
        // Arrange
        OrderItem orderItem = new OrderItem();
        StockItem stockItem = new StockItem();

        // Act
        orderItem.setStockItem(stockItem);

        // Assert
        assertEquals(stockItem, orderItem.getStockItem());
    }

    @Test
    void setReplacementOrder() {
        // Arrange
        OrderItem orderItem = new OrderItem();
        ReplacementOrder replacementOrder = new ReplacementOrder();

        // Act
        orderItem.setReplacementOrder(replacementOrder);

        // Assert
        assertEquals(replacementOrder, orderItem.getReplacementOrder());
    }
}