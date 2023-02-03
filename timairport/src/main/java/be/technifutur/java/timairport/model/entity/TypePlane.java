package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypePlane typePlane = (TypePlane) o;
        return id.equals(typePlane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
