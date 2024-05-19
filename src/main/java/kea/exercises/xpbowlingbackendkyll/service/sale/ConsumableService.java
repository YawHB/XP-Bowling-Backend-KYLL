package kea.exercises.xpbowlingbackendkyll.service.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.ConsumableRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsumableService {

    private final ConsumableRepository consumableRepository;

    public ConsumableService(ConsumableRepository consumableRepository) {
        this.consumableRepository = consumableRepository;
    }

    public Consumable getConsumableById(Integer key) {
        try {
            return consumableRepository.findById(key).get();
        } catch (Exception e) {
            return null;
        }




    }


}
