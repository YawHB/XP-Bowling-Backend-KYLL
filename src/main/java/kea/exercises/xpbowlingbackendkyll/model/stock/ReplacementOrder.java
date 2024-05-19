package kea.exercises.xpbowlingbackendkyll.model.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReplacementOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String title;
    private double TotalPrice;
    private LocalDateTime TimeDate;

    public ReplacementOrder(String title, double TotalPrice, LocalDateTime TimeDate) {
        this.title = title;
        this.TotalPrice = TotalPrice;
        this.TimeDate = LocalDateTime.now();
    }
}
