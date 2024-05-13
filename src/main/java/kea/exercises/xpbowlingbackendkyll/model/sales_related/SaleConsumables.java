package kea.exercises.xpbowlingbackendkyll.model.sales_related;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SaleConsumables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int consumablesId;
    private int saleId;
    private int amount;
    private int bundlePrice;

}
