package kea.exercises.xpbowlingbackendkyll.service.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import kea.exercises.xpbowlingbackendkyll.repository.sale.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    public List<Sale> getSales() {
        return saleRepository.findAll();

    }
}
