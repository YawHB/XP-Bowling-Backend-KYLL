package kea.exercises.xpbowlingbackendkyll.repository.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
