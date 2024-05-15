package kea.exercises.xpbowlingbackendkyll.model.customer;

import jakarta.persistence.*;
import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityBooking;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate ReservationDate;
    private double totalPrice;
    @ManyToOne
    private Customer customer;

}
