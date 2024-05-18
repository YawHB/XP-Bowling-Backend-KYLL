package kea.exercises.xpbowlingbackendkyll.controller.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import kea.exercises.xpbowlingbackendkyll.service.sale.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping("/sales")
    public List<Sale> getSales() {
        return saleService.getSales();

    }
}
