package kea.exercises.xpbowlingbackendkyll.controller.stock;


import kea.exercises.xpbowlingbackendkyll.model.stock.OrderItem;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import kea.exercises.xpbowlingbackendkyll.service.stockServices.OrderItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderItemControllerTest {

    @Mock
    private OrderItemService orderItemService;

    @InjectMocks
    private OrderItemController orderItemController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderItemController).build();
    }

    @Test
    void testGetAllOrderItems() throws Exception {
        OrderItem orderItem1 = new OrderItem(10, new StockItem(), new ReplacementOrder());
        OrderItem orderItem2 = new OrderItem(20, new StockItem(), new ReplacementOrder());
        when(orderItemService.findAllOrderItems()).thenReturn(Arrays.asList(orderItem1, orderItem2));

        mockMvc.perform(get("/orderitems"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].amountToOrder").value(10))
                .andExpect(jsonPath("$[1].amountToOrder").value(20));
    }

    @Test
    void testGetOrderItemById() {
        OrderItem orderItem = new OrderItem(10, new StockItem(), new ReplacementOrder());
        when(orderItemService.getOrderItemById(1)).thenReturn(Optional.of(orderItem));

        ResponseEntity<OrderItem> response = orderItemController.getOrderItemById(1);

        assertEquals(10, response.getBody().getAmountToOrder());
    }
}
