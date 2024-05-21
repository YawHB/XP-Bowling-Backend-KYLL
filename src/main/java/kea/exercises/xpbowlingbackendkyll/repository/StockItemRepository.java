package kea.exercises.xpbowlingbackendkyll.repository;

import kea.exercises.xpbowlingbackendkyll.model.stock.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockItemRepository extends JpaRepository<StockItem, Integer>{

    Optional<StockItem> findByName(String itemName);
}
