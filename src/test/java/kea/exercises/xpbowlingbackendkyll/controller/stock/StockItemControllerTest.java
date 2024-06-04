package kea.exercises.xpbowlingbackendkyll.controller.stock;

import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import kea.exercises.xpbowlingbackendkyll.service.stockServices.StockItemService;
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

class StockItemControllerTest {

    @Mock
    private StockItemService stockItemService;

    @InjectMocks
    private StockItemController stockItemController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(stockItemController).build();
    }

    @Test
    void testGetAllStockItems() throws Exception {
        StockItem stockItem1 = new StockItem("Item1", 10.0, 100);
        StockItem stockItem2 = new StockItem("Item2", 20.0, 200);

        when(stockItemService.findAll()).thenReturn(Arrays.asList(stockItem1, stockItem2));

        mockMvc.perform(get("/stockitems"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Item1"))
                .andExpect(jsonPath("$[1].name").value("Item2"));
    }

    @Test
    void testGetStockItemById() {
        StockItem stockItem = new StockItem("Item1", 10.0, 100);
        when(stockItemService.findById(1)).thenReturn(Optional.of(stockItem));

        ResponseEntity<StockItem> response = stockItemController.getStockItemById(1);
    }

    @Test
    void testGetStockItemByName() {
        StockItem stockItem = new StockItem("Item1", 10.0, 100);

        when(stockItemService.findStockItemByName("Item1")).thenReturn(Optional.of(stockItem));

        ResponseEntity<StockItem> responseEntity = stockItemController.getStockItemByName("Item1");
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(stockItem, responseEntity.getBody());
    }
}
