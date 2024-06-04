package kea.exercises.xpbowlingbackendkyll.repository.stock;

import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplacementOrderRepository extends JpaRepository<ReplacementOrder, Integer> {
}
