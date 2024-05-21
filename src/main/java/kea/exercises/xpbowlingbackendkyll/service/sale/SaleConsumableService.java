package kea.exercises.xpbowlingbackendkyll.service.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.SaleConsumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.SaleConsumableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleConsumableService {

    private final SaleConsumableRepository saleConsumableRepository;

    public SaleConsumableService(SaleConsumableRepository saleConsumableRepository) {
        this.saleConsumableRepository = saleConsumableRepository;
    }
    public void addSaleConsumable(SaleConsumable saleConsumable) {
        saleConsumableRepository.save(saleConsumable);
    }

    public List<SaleConsumable> getConsumablesBySaleId(int id) {
        return saleConsumableRepository.findAllBySaleId(id);
    }
}
