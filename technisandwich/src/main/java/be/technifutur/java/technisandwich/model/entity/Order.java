package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id", nullable = false)
    private UUID        id;

    @Column(name = "order_date", nullable = false)
    private LocalDate   orderDate;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate   deliveryDate;

    @Column(name = "discount", nullable = false)
    private float       discount;

    @Column(name = "state", nullable = false)
    private boolean     state;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User        user;

    @ManyToMany
    @JoinTable(
            name = "sandwich_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id"))
    private List<Sandwich> sandwiches;


}
