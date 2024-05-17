package kea.exercises.xpbowlingbackendkyll.config;

import kea.exercises.xpbowlingbackendkyll.model.sale.Sale;
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

    public InitDataSales(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing sales data");

        createSales();
    }


    private void createSales() {
        List<Sale> sales = new ArrayList<>() {
            {
                add(new Sale(new Timestamp(System.currentTimeMillis()), 100.0));
                add(new Sale(new Timestamp(System.currentTimeMillis()), 200.0));
                add(new Sale(new Timestamp(System.currentTimeMillis()), 300.0));
            }
        };

        saleRepository.saveAll(sales);
        }


    }
