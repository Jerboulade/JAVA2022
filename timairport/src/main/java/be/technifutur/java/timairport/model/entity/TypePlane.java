package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class TypePlane {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="type_id")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private int capacity;

    @ManyToMany(mappedBy = "planeTypesAllowed")
    private List<Airport> airports;

    @OneToMany(mappedBy = "type")
    private List<Plane> planes;
}
