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
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ConsumableRepositoryTest {
    @Autowired
    private ConsumableRepository consumableRepository;


    @Test
    void shouldCreateConsumableWithExpectedAttributes() {

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
    void shouldIgnoreIdWhenCreatingNewConsumable() {
        //Arrange
        Consumable wine = Consumable.builder().
                title("yaw").
                price(50).
                id(10).
                build();

        //Act
        Consumable savedWine = consumableRepository.save(wine);

        //Assert
        assertNotNull(savedWine);
        assertNotEquals(10, savedWine.getId());
        System.out.println("The id is " + savedWine.getId());
    }


    @Test
    void shouldUpdateConsumableAttributesCorrectly() {
        //Arrange
        Consumable peanuts = Consumable.builder().
                title("Peanuts").
                price(10).
                build();

        Consumable savedWine = consumableRepository.save(peanuts);
        System.out.println("The price was " + peanuts.getPrice());

        //Act

        savedWine.setPrice(20);

        Consumable updatedPeanuts = consumableRepository.save(savedWine);

        //Assert
        assertEquals(20, updatedPeanuts.getPrice());
        System.out.println("The price is " + updatedPeanuts.getPrice());


    }



    @Test
    void shouldSaveAllConsumablesAndReturnSameConsumables() {
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