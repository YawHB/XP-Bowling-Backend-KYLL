package kea.exercises.xpbowlingbackendkyll.config;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
import kea.exercises.xpbowlingbackendkyll.model.sale.SaleConsumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.ConsumableRepository;
import kea.exercises.xpbowlingbackendkyll.repository.sale.SaleConsumableRepository;
import kea.exercises.xpbowlingbackendkyll.repository.sale.SaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
@Order(2) // This CommandLineRunner will run after the one with @Order(1)
public class InitDataSales implements CommandLineRunner {

    // Inject repositories or services you need here
    private final SaleRepository saleRepository;
    private final ConsumableRepository consumableRepository;
    private final SaleConsumableRepository saleConsumableRepository;

    public InitDataSales(SaleRepository saleRepository, ConsumableRepository consumableRepository, SaleConsumableRepository saleConsumableRepository) {
        this.saleRepository = saleRepository;
        this.consumableRepository = consumableRepository;
        this.saleConsumableRepository = saleConsumableRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing sales data");

        createSales();
        createConsumables();
        createSaleConsumables();
    }


    public void createSales() {


        List<Sale> salesToCreate = List.of(
                new Sale(new Timestamp(System.currentTimeMillis())),
        new Sale(new Timestamp(System.currentTimeMillis())),
        new Sale(new Timestamp(System.currentTimeMillis()))
        );

        //Only save the sales if they don't already exist
        List<Sale> existingSales = saleRepository.findAll();
        if(existingSales.size() != salesToCreate.size()){
            saleRepository.saveAll(salesToCreate);
        }
    }


    public void createConsumables() {
        List<Consumable> consumablesToCreate = List.of(
                new Consumable("Coke", 10),
                new Consumable("Fanta", 15),
                new Consumable("Sprite", 20),
                new Consumable("Water", 25),
                new Consumable("Beer", 30)
        );

        for (Consumable consumableToCreate : consumablesToCreate) {
            // Check if a consumable with the same name already exists
            boolean exists = consumableRepository.findByTitle(consumableToCreate.getTitle()).isPresent();

            // If it doesn't exist, save it
            if (!exists) {
                consumableRepository.save(consumableToCreate);
            }
        }
    }

    public void createSaleConsumables() {

        // Get the sales and consumables from the database
        List<Sale> sales = saleRepository.findAll();
        List<Consumable> consumables = consumableRepository.findAll();

        // Create the SaleConsumable objects
        List<SaleConsumable> saleConsumables = List.of(
    new SaleConsumable(2, sales.get(0), consumables.get(0)),
        new SaleConsumable(3, sales.get(0), consumables.get(2)),
        new SaleConsumable(3, sales.get(1), consumables.get(2)),
        new SaleConsumable(1, sales.get(2), consumables.get(3)),
        new SaleConsumable(1, sales.get(2), consumables.get(0)),
        new SaleConsumable(1, sales.get(0), consumables.get(1))
        );

        for(SaleConsumable saleConsumable : saleConsumables){
            // Check if the sale consumable already exists
            boolean exists = saleConsumableRepository.existsBySaleAndConsumable(saleConsumable.getSale(), saleConsumable.getConsumable());

            // If it doesn't exist, save it
            if (!exists) {
                saleConsumableRepository.save(saleConsumable);
            }
        }


    }

}