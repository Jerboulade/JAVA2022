package be.technifutur.java.roombook.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    @Column(name = "room_id")
    private UUID    id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    @ManyToMany
    private List<Material> materials;
}
