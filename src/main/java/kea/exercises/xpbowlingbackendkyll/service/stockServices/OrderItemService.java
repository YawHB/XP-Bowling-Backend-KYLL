package kea.exercises.xpbowlingbackendkyll.service.stockServices;

import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.repository.stock.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(int id) {
        return orderItemRepository.findById(id);
    }
}
