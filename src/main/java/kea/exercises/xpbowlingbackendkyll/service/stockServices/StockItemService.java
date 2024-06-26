package kea.exercises.xpbowlingbackendkyll.service.stockServices;

import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import kea.exercises.xpbowlingbackendkyll.repository.stock.StockItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockItemService {

    private final StockItemRepository stockItemRepository;

    public StockItemService(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    public List<StockItem> findAll() {
        return stockItemRepository.findAll();
    }

    public Optional<StockItem> findById(int id) {
        return stockItemRepository.findById(id);
    }


    public Optional<StockItem> findStockItemByName(String name) {
        return stockItemRepository.findByName(name);
    }
}
