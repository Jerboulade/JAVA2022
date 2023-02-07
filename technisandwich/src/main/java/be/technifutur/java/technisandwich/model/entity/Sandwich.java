package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
//@Table
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sandwich_id", nullable = false)
    private Long            id;

    @Column(name = "name", nullable = false, unique = true)
    private String          name;

    @Column(name = "description")
    private String          description;

    @Column(name = "price", nullable = false)
    private Float           price;

    @ManyToMany(mappedBy = "sandwiches")
    private List<Cart>      cart;

    @ManyToMany(mappedBy = "sandwiches")
    private List<Order>      order;

    @ManyToMany
    @JoinTable(
            name = "sandwich_diet",
            joinColumns = @JoinColumn(name = "sandwich_id"),
            inverseJoinColumns = @JoinColumn(name = "diet_id"))
    private List<Diet>      diets;
}
