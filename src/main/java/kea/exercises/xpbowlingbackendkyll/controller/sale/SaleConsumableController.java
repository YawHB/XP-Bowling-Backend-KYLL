package kea.exercises.xpbowlingbackendkyll.controller.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.SaleConsumable;
import kea.exercises.xpbowlingbackendkyll.service.sale.SaleConsumableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleConsumableController {

    private final SaleConsumableService saleConsumableService;



    public SaleConsumableController(SaleConsumableService saleConsumableService) {
        this.saleConsumableService = saleConsumableService;

    }


    @GetMapping("/sales/{id}/consumables")
    public List<SaleConsumable> getSaleWithConsumables(@PathVariable int id) {
        return saleConsumableService.getConsumablesBySaleId(id);
    }
    }




