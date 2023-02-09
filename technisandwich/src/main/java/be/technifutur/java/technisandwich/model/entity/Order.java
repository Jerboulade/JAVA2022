package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "\"order\"")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id", nullable = false)
    private UUID        id;

    @Column(name = "order_date")
    private LocalDate   orderDate = LocalDate.now();

    @Column(name = "delivery_date")
    private LocalDate   deliveryDate;

    @Column(name = "discount")
    private float       discount = 0;

    @Column(name = "state")
    private boolean     state = true;

    @ManyToOne
    //, nullable = false
    @JoinColumn(name = "user_id")
    private User        user;

    @ManyToMany
    @JoinTable(
            name = "sandwich_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id"))
    private List<Sandwich> sandwiches;


}
