package kea.exercises.xpbowlingbackendkyll.controller.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import kea.exercises.xpbowlingbackendkyll.model.sale.SaleConsumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.SaleConsumableRepository;
import kea.exercises.xpbowlingbackendkyll.service.sale.ConsumableService;
import kea.exercises.xpbowlingbackendkyll.service.sale.SaleConsumableService;
import kea.exercises.xpbowlingbackendkyll.service.sale.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SaleConsumableController {

    private final SaleConsumableService saleConsumableService;
    private final SaleService saleService;
    private final ConsumableService consumableService;


    public SaleConsumableController(SaleConsumableService saleConsumableService, SaleService saleService, ConsumableService consumableService) {
        this.saleConsumableService = saleConsumableService;
        this.saleService = saleService;
        this.consumableService = consumableService;
    }


    @GetMapping("/sales/{id}/consumables")
    public List<SaleConsumable> getSaleWithConsumables(@PathVariable int id) {
        return saleConsumableService.getConsumablesBySaleId(id);
    }
    }




