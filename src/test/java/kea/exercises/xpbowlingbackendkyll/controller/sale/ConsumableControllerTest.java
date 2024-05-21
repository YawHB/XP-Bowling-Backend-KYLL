package kea.exercises.xpbowlingbackendkyll.controller.sale;

import kea.exercises.xpbowlingbackendkyll.model.sale.Consumable;
import kea.exercises.xpbowlingbackendkyll.service.sale.ConsumableService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;


public class ConsumableControllerTest {


    @Test
    void getConsumableById() {


        //Arrange
        ConsumableService mockService = Mockito.mock(ConsumableService.class);
        ConsumableController mockController = Mockito.mock(ConsumableController.class);


        Consumable expectedConsumable = new Consumable("Wine", 50);
        when(mockService.getConsumableById(1)).thenReturn(expectedConsumable);

        //Act

        //Assert
    }
}
