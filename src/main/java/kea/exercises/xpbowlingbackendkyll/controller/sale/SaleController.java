package kea.exercises.xpbowlingbackendkyll.controller.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import kea.exercises.xpbowlingbackendkyll.model.sale.SaleConsumable;
import kea.exercises.xpbowlingbackendkyll.service.sale.ConsumableService;
import kea.exercises.xpbowlingbackendkyll.service.sale.SaleConsumableService;
import kea.exercises.xpbowlingbackendkyll.service.sale.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class SaleController {

    private final SaleService saleService;
    private final ConsumableService consumableService;

    private final SaleConsumableService saleConsumableService;

    public SaleController(SaleService saleService, ConsumableService consumableService, SaleConsumableService saleConsumableService) {
        this.saleService = saleService;
        this.consumableService = consumableService;
        this.saleConsumableService = saleConsumableService;
    }


    @GetMapping("/sales")
    public List<Sale> getSales() {
        return saleService.getSales();



    }

    // Map is used to get the consumable id and the quantity of the consumable
    @PostMapping("/sales")
    public Sale addSale(@RequestBody Map<Integer, Integer> consumables) {
        Sale sale = new Sale(new Timestamp(System.currentTimeMillis()));
        Sale savedSale = saleService.addSale(sale);

        // entry = one object
        // entrySet = the entire array of objects
        for (var entry : consumables.entrySet()) {
            Consumable consumable = consumableService.getConsumableById(entry.getKey());
            SaleConsumable saleConsumable = new SaleConsumable(entry.getValue(), savedSale, consumable);
            saleConsumableService.addSaleConsumable(saleConsumable);
        }

        return savedSale;
    }
}
