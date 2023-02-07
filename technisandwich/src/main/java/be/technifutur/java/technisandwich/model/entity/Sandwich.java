package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
//@Table
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sandwich_id", nullable = false)
    private Long    id;

    @Column(name = "name", nullable = false)
    private String  name;

    @Column(name = "description", nullable = false)
    private String  description;

    @Column(name = "price", nullable = false)
    private Float   price;
}
