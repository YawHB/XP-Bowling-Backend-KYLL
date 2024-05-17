package kea.exercises.xpbowlingbackendkyll.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class InitDataSales implements CommandLineRunner {

    // Inject repositories or services you need here

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing sales data");
        // Initialize your sales data here
    }
}