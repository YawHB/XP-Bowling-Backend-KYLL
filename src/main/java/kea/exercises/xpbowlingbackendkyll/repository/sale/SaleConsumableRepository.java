package kea.exercises.xpbowlingbackendkyll.repository.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import kea.exercises.xpbowlingbackendkyll.model.sale.SaleConsumable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleConsumableRepository extends JpaRepository<SaleConsumable, Integer> {

    List<SaleConsumable> findAllBySaleId(int id);

    boolean existsBySaleAndConsumable(Sale sale, Consumable consumable);
}
