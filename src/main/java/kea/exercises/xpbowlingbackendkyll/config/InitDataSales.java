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
import java.util.ArrayList;
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
        List<Sale> sales = new ArrayList<>(){{
            add(new Sale(new Timestamp(System.currentTimeMillis())));
            add(new Sale(new Timestamp(System.currentTimeMillis())));
            add(new Sale(new Timestamp(System.currentTimeMillis())));
        }};
        saleRepository.saveAll(sales);
        }




public void createConsumables() {
    List<Consumable> consumables = new ArrayList<>(){{
        add(new Consumable("Coke", 20));
        add(new Consumable("Fanta", 20));
        add(new Consumable("Sprite", 20));
        add(new Consumable("Water", 20));
        add(new Consumable("Beer", 20));
    }};
    consumableRepository.saveAll(consumables);

    }

    public void createSaleConsumables() {

        // Get the sales and consumables from the database
        List<Sale> sales = saleRepository.findAll();
        List<Consumable> consumables = consumableRepository.findAll();

        // Create the SaleConsumable objects
        List<SaleConsumable> saleConsumables = new ArrayList<>(){{
            add(new SaleConsumable(2, sales.get(0), consumables.get(0)));
            add(new SaleConsumable(1, sales.get(0), consumables.get(1)));
            add(new SaleConsumable(3, sales.get(0), consumables.get(2)));
            add(new SaleConsumable(3, sales.get(1), consumables.get(2)));
            add(new SaleConsumable(1, sales.get(2), consumables.get(3)));
            add(new SaleConsumable(1, sales.get(2), consumables.get(0)));
        }};
        saleConsumableRepository.saveAll(saleConsumables);
    }

}