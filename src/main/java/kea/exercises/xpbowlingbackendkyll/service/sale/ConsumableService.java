package kea.exercises.xpbowlingbackendkyll.service.sale;

import jakarta.persistence.EntityNotFoundException;
import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.ConsumableRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsumableService {

    private final ConsumableRepository consumableRepository;

    public ConsumableService(ConsumableRepository consumableRepository) {
        this.consumableRepository = consumableRepository;
    }

    public Consumable getConsumableById(Integer id) {

            return consumableRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Consumable with id " + id + " not found :("));

    }


    public Consumable createConsumable(Consumable consumable) {
        return consumableRepository.save(consumable);
    }
}
