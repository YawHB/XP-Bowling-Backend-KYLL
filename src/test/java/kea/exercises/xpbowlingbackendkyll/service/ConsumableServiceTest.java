package kea.exercises.xpbowlingbackendkyll.service;


import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.repository.sale.ConsumableRepository;
import kea.exercises.xpbowlingbackendkyll.service.sale.ConsumableService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ConsumableServiceTest {

    @Mock
    private ConsumableRepository consumableRepository;

    @InjectMocks
    private ConsumableService consumableService;



    //h1 POST CONSUMABLE
    @Test
    public void testCreateConsumable() {

        // Arrange
        Consumable peanuts = Consumable.builder().title("Peanuts").price(10).build();

        // Act
        when(consumableRepository.save(any(Consumable.class))).thenReturn(peanuts);

        // Assert
        assertNotNull(consumableService.createConsumable(peanuts));


    }

    @Test
    public void testCreateConsumableWithEmptyStringTitle() {
        // Arrange
        Consumable invalidConsumable = Consumable.builder().title("").price(20).build();

        //Act, Assert
        assertThrows(IllegalArgumentException.class, () -> {
            consumableService.createConsumable(invalidConsumable);
        });

    }


    @Test
    public void failToCreateProductWithNullTitle() {
        // Arrange
        Consumable nullTitleConsumable = Consumable.builder().title(null).price(20).build();

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> {
            consumableService.createConsumable(nullTitleConsumable);
        });
    }

    @Test
    public void createProductWithTitleAtMaxLength() {
        // Arrange
        String maxLengthTitle = "12345678901234567890"; // 20 characters
        Consumable maxLengthTitleConsumable = Consumable.builder().title(maxLengthTitle).price(20).build();

        // Act
        when(consumableRepository.save(any(Consumable.class))).thenReturn(maxLengthTitleConsumable);

        // Assert
        assertNotNull(consumableService.createConsumable(maxLengthTitleConsumable));
    }

    @Test
    public void createAConsumableWithTitleTooLong() {

        //Arrange
        Consumable consumableWithTitleTooLong = Consumable.builder().title("this title is too long").price(20).build();

        //Act, Assert
        assertThrows(IllegalArgumentException.class, () -> {
            consumableService.createConsumable(consumableWithTitleTooLong);
        });

    }

    @Test
    public void failToCreateProductWithSpecialCharactersInTitle() {
        // Arrange
        Consumable specialCharTitleConsumable = Consumable.builder().title("Water@#").price(20).build();

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> {
            consumableService.createConsumable(specialCharTitleConsumable);
        });
    }


    @Test
    public void createProductWithPriceAtMinValue() {
        // Arrange
        Consumable minValuePriceConsumable = Consumable.builder().title("Water").price(0).build();

        // Act
        when(consumableRepository.save(any(Consumable.class))).thenReturn(minValuePriceConsumable);

        // Assert
        assertNotNull(consumableService.createConsumable(minValuePriceConsumable));
    }

    @Test
    public void failToCreateProductWherePriceIsLessThan0() {

        //Arrange
        Consumable negativePriceConsumable = Consumable.builder().title("Water").price(-1).build();

        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            consumableService.createConsumable(negativePriceConsumable);
        });
    }



    @Test
    public void createProductWithLargePrice() {
        // Arrange
        Consumable largePriceConsumable = Consumable.builder().title("Water").price(1000000).build();

        // Act
        when(consumableRepository.save(any(Consumable.class))).thenReturn(largePriceConsumable);

        // Assert
        assertNotNull(consumableService.createConsumable(largePriceConsumable));
    }


    //h1 UPDATE CONSUMABLE
    @Test
    public void testUpdateConsumablePrice() {
        // Arrange
        Consumable existingConsumable = Consumable.builder().title("Water").price(10).build();
        when(consumableRepository.findById(any(Integer.class))).thenReturn(Optional.of(existingConsumable));

        Consumable updatedConsumable = Consumable.builder().title("Water").price(20).build();
        when(consumableRepository.save(any(Consumable.class))).thenReturn(updatedConsumable);

        // Act
        Consumable result = consumableService.updateConsumable(1, updatedConsumable);

        // Assert
        assertNotNull(result);
        assertEquals(20, result.getPrice());
    }

    @Test
    public void failToUpdateProductWherePriceIsLessThan0() {
        //Arrange
        Consumable existingConsumable = Consumable.builder().title("Water").price(10).build();
        when(consumableRepository.findById(any(Integer.class))).thenReturn(Optional.of(existingConsumable));

        //Act
        Consumable updatedConsumable = Consumable.builder().title("Water").price(-1).build();

        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            consumableService.updateConsumable(1, updatedConsumable);
        });




    }

}