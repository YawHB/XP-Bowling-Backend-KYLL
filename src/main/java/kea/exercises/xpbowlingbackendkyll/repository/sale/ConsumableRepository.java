package kea.exercises.xpbowlingbackendkyll.repository.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsumableRepository extends JpaRepository<Consumable, Integer> {
    Optional<Consumable> findByTitle(String name);
}
