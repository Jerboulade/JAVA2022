package be.technifutur.java.roombook.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    @Column(name = "material_id")
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "materials")
    private List<Room> rooms;
}
