package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Entity
@Getter @Setter
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pilot_id")
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "first_name", nullable = false)
    private String lastName;
}
