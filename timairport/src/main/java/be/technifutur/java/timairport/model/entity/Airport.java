package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "airport_id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;

    @Column(name = "plane_parking", nullable = false)
    private int planeParking;

    @ManyToMany
    @JoinTable(
            name = "airport_planes_allowed",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "type_plane_id")
    )
    private List<TypePlane> planeTypesAllowed;
}

