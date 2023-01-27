package be.technifutur.java.timairport.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "origin_country", nullable = false)
    private String originCountry;

    @OneToMany(mappedBy = "company")
    private List<Plane> planes;

    @OneToMany(mappedBy = "company")
    private List<Pilot> pilots;

}
