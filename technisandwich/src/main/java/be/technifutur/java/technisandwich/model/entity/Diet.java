package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diet_id")
    private UUID    id;

    @Column(name = "name", nullable = false)
    private String  name;

    @Column(name = "description")
    private String  description;

    @ManyToMany(mappedBy = "diets")
    List<Sandwich>  sandwiches;
}
