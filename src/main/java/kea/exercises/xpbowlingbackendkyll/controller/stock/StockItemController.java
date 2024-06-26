package kea.exercises.xpbowlingbackendkyll.controller.stock;

import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import kea.exercises.xpbowlingbackendkyll.service.stockServices.StockItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockitems")
public class StockItemController {

    private final StockItemService stockItemService;

    public StockItemController(StockItemService stockItemService) {
        this.stockItemService = stockItemService;
    }

    @GetMapping
    public List<StockItem> getAllStockItems() {
        return stockItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockItem> getStockItemById(@PathVariable int id) {
        return ResponseEntity.of(stockItemService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<StockItem> getStockItemByName(@PathVariable String name) {
        return ResponseEntity.of(stockItemService.findStockItemByName(name));
    }


}
