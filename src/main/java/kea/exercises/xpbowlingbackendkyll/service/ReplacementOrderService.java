package kea.exercises.xpbowlingbackendkyll.service;

import kea.exercises.xpbowlingbackendkyll.dtos.OrderItemResponseDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.ReplacementOrderRequestDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.ReplacementOrderResponseDTO;
import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.repository.OrderItemRepository;
import kea.exercises.xpbowlingbackendkyll.repository.ReplacementOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplacementOrderService {

            private final ReplacementOrderRepository replacementOrderRepository;
            private final OrderItemRepository orderItemRepository;

            public ReplacementOrderService(ReplacementOrderRepository replacementOrderRepository, OrderItemRepository orderItemRepository) {
                this.replacementOrderRepository = replacementOrderRepository;
                this.orderItemRepository = orderItemRepository;
            }

            public List<ReplacementOrder> findAllReplacementOrders() {
                return replacementOrderRepository.findAll();
            }

    public Optional<ReplacementOrder> getReplacementOrderById(int id) {
        return replacementOrderRepository.findById(id);
    }

    public ReplacementOrderResponseDTO createReplacementOrder(ReplacementOrderRequestDTO replacementOrderAndOrderItems) {

                ReplacementOrder replacementOrder = replacementOrderAndOrderItems.replacementOrder();
                List<OrderItem> orderItemsList = replacementOrderAndOrderItems.orderItems();

                ReplacementOrder newReplacementOrder = replacementOrderRepository.save(replacementOrder);
                System.out.println(replacementOrder);


                orderItemsList.forEach(orderItem -> orderItem.setReplacementOrder(newReplacementOrder));
                List<OrderItemResponseDTO> newOrderItemList = orderItemRepository.saveAll(orderItemsList).stream().map(orderItem -> new OrderItemResponseDTO(orderItem.getAmountToOrder(), orderItem.getStockItem())).toList();

                // only a perhaps:
                // TODO: get stockItem name, price, and amount in stock in response on orderItem



               return new ReplacementOrderResponseDTO(newReplacementOrder, newOrderItemList);


    }
}
