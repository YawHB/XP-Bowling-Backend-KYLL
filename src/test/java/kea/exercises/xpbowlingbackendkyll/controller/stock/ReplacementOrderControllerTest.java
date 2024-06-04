package kea.exercises.xpbowlingbackendkyll.controller.stock;

import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.ReplacementOrderRequestDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.ReplacementOrderResponseDTO;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.service.stockServices.ReplacementOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ReplacementOrderControllerTest {

    @Mock
    private ReplacementOrderService replacementOrderService;

    @InjectMocks
    private ReplacementOrderController replacementOrderController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(replacementOrderController).build();
    }

    @Test
    void testGetAllReplacementOrders() throws Exception {
        ReplacementOrder replacementOrder1 = new ReplacementOrder("Order1", 100.0, LocalDateTime.now());
        ReplacementOrder replacementOrder2 = new ReplacementOrder("Order2", 200.0, LocalDateTime.now());

        when(replacementOrderService.findAllReplacementOrders()).thenReturn(Arrays.asList(replacementOrder1, replacementOrder2));

        mockMvc.perform(get("/replacementorders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Order1"))
                .andExpect(jsonPath("$[1].title").value("Order2"));
    }

    @Test
    void testGetReplacementOrderById() {
        ReplacementOrder replacementOrder = new ReplacementOrder("Order1", 100.0, LocalDateTime.now());
        when(replacementOrderService.getReplacementOrderById(1)).thenReturn(Optional.of(replacementOrder));

        ResponseEntity<ReplacementOrder> response = replacementOrderController.getReplacementOrderById(1);
        assertEquals(replacementOrder, Objects.requireNonNull(response.getBody()));
    }

    @Test
    void testAddReplacementOrder() throws Exception {
        ReplacementOrder replacementOrder = new ReplacementOrder("Order1", 100.0, LocalDateTime.now());
        ReplacementOrderRequestDTO replacementOrderRequestDTO = new ReplacementOrderRequestDTO(replacementOrder, null);

        when(replacementOrderService.createReplacementOrder(replacementOrderRequestDTO)).thenReturn(new ReplacementOrderResponseDTO(replacementOrder, null));

        MvcResult mvcResult = mockMvc.perform(post("/replacementorders")
                .contentType("application/json")
                .content("""
    {
        "replacementOrder": {
                "title": "controller test order",
                "totalPrice": 444.0,
                "timeDate": "2024-05-19T19:56:51.015"
             },
        "orderItems": [
            {
                "amountToOrder": 1,
                "stockItem": {"name": "Bowling-Ball 12 kg"}
            }
        ]
    }
"""))
                .andExpect(status().isCreated())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        System.out.println(response);


//                .andExpect(jsonPath("$.replacementOrder.title").value("controller test order"))
//                .andExpect(jsonPath("$.replacementOrder.totalPrice").value(444.0));
    }
}
