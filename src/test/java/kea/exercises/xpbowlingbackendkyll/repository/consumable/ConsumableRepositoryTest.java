package kea.exercises.xpbowlingbackendkyll.repository.consumable;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.ConsumableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
// uses a virtue database instead of the actual database for testing purposes
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ConsumableRepositoryTest {
    @Autowired
    private ConsumableRepository consumableRepository;


    @Test
    void ConsumableRepository_SaveConsumable_ReturnSavedConumable() {

        //Arrange
        // builder pattern builds the object with the given parameters
        Consumable wine = Consumable.builder().
                title("Wine").
                price(50).
                build();


        //Act

        Consumable savedWine = consumableRepository.save(wine);


        //Assert
        assertNotNull(savedWine);
        assertTrue(savedWine.getId() > 0);
    }


    @Test
    void ConsumableRepository_SaveAllConsumables_ReturnConsumable() {
        List<Consumable> products = new ArrayList<>();
        //Arrange
        products.add(Consumable.builder().
                title("Wine").
                price(50).
                build());

        products.add(Consumable.builder().
                title("Fanta").
                price(25).
                build());

        products.add(Consumable.builder().
                title("Water").
                price(15).
                build());



        //Act

        List<Consumable> savedProducts = consumableRepository.saveAll(products);

        //Assert
        assertEquals(products, savedProducts);




    }
}