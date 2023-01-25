package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Hotel extends Contactable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long        id;

    @Column(scale = 1, nullable = false)
    private short       stars;

    @Column(nullable = false)
    private String      name;

    @OneToOne
    @JoinColumn(name = "groom_id", unique = true)
    private Employee    groom;

    @OneToMany(mappedBy = "hotel")
    private Set<Room>   rooms;

    @OneToMany(mappedBy = "hotel")
    private Set<WorkDetail> workDetails = new LinkedHashSet<>();

}
