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
    private double totalPrice;
    private LocalDateTime timeDate;

    public ReplacementOrder(String title, double totalPrice, LocalDateTime timeDate) {
        this.title = title;
        this.totalPrice = totalPrice;
        this.timeDate = timeDate;
    }
}
