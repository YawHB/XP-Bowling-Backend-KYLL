package kea.exercises.xpbowlingbackendkyll.service.sale;

import jakarta.persistence.EntityNotFoundException;
import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.ConsumableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        validateTitle(consumable.getTitle());
        validatePrice(consumable.getPrice());

        return consumableRepository.save(consumable);
    }


    public Consumable updateConsumable(Integer id, Consumable updatedConsumable) {
        Consumable consumable = consumableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consumable with id " + id + " not found"));


        validatePrice(updatedConsumable.getPrice());

        consumable.setPrice(updatedConsumable.getPrice());
        return consumableRepository.save(consumable);
    }

    public List<Consumable> getAllConsumables() {
        return consumableRepository.findAll();
    }


    private void validateTitle(String title) {
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title can't be null or an empty string, silly you");

        if (title.length() >20 )  throw new IllegalArgumentException("Title cannot be longer than 20 characters");

        if (!title.matches("[a-zA-Z0-9 ]*")) throw new IllegalArgumentException("Title can't contain special characters");


    }

    private void validatePrice(Double price) {
        if(price < 0) throw new IllegalArgumentException("Price has to be at least 0");
    }





}
