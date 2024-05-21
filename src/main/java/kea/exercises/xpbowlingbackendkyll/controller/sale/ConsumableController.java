package kea.exercises.xpbowlingbackendkyll.controller.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.service.sale.ConsumableService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumableController {

    private final ConsumableService consumableService;

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }


    @GetMapping("/consumables/{id}")
    public Consumable getConsumableById(@PathVariable int id) {
        return consumableService.getConsumableById(id);
    }

   @PostMapping("/consumables")
    public Consumable createConsumable(@RequestBody Consumable consumable) {
        return consumableService.createConsumable(consumable);
    }
    @PutMapping("/consumables/{id}")
    public Consumable updateConsumable(@PathVariable int id, @RequestBody Consumable updatedConsumable) {
        return consumableService.updateConsumable(id, updatedConsumable);
    }

}
