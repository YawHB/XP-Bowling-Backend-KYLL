package kea.exercises.xpbowlingbackendkyll.model.customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;

    @OneToMany()
    @JoinColumn(name = "customer_id")
    private List<Reservation> reservations;


    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
