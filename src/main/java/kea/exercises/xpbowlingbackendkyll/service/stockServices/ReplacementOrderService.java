package kea.exercises.xpbowlingbackendkyll.service.stockServices;

import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.OrderItemRequestDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.OrderItemResponseDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.ReplacementOrderRequestDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.ReplacementOrderResponseDTO;
import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import kea.exercises.xpbowlingbackendkyll.repository.OrderItemRepository;
import kea.exercises.xpbowlingbackendkyll.repository.ReplacementOrderRepository;
import kea.exercises.xpbowlingbackendkyll.repository.StockItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReplacementOrderService {

            private final ReplacementOrderRepository replacementOrderRepository;
            private final OrderItemRepository orderItemRepository;
            private final StockItemRepository stockItemRepository;


            public ReplacementOrderService(ReplacementOrderRepository replacementOrderRepository, OrderItemRepository orderItemRepository, StockItemRepository stockItemRepository) {
                this.replacementOrderRepository = replacementOrderRepository;
                this.orderItemRepository = orderItemRepository;
                this.stockItemRepository = stockItemRepository;

            }

            public List<ReplacementOrder> findAllReplacementOrders() {
                return replacementOrderRepository.findAll();
            }

    public Optional<ReplacementOrder> getReplacementOrderById(int id) {
        return replacementOrderRepository.findById(id);
    }


    public ReplacementOrderResponseDTO createReplacementOrder(ReplacementOrderRequestDTO replacementOrderAndOrderItems) {

        ReplacementOrder replacementOrder = replacementOrderAndOrderItems.replacementOrder();
        List<OrderItemRequestDTO> orderItemsList = replacementOrderAndOrderItems.orderItems();

        ReplacementOrder newReplacementOrder = replacementOrderRepository.save(replacementOrder);

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequestDTO orderItemRequest : orderItemsList) {
            Optional<StockItem> stockItemOptional = stockItemRepository.findByName(orderItemRequest.getStockItem().getName());
            if (stockItemOptional.isPresent()) {
                StockItem stockItem = stockItemOptional.get();
                OrderItem orderItem = new OrderItem(orderItemRequest.getAmountToOrder(), stockItem, newReplacementOrder);
                orderItems.add(orderItem);
            } else {
                throw new RuntimeException("StockItem with name " + orderItemRequest.getStockItem().getName() + " not found");
            }
        }

        List<OrderItemResponseDTO> newOrderItemList = orderItemRepository.saveAll(orderItems).stream().map(orderItem -> new OrderItemResponseDTO(orderItem.getAmountToOrder(), orderItem.getStockItem())).toList();

        return new ReplacementOrderResponseDTO(newReplacementOrder, newOrderItemList);
    }

}
