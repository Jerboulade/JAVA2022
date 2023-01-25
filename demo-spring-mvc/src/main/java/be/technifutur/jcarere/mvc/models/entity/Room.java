package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Room {
    @Id
    @Column(name = "room_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        id;

    @Column(nullable = false)
    private int         number;

    @Column(nullable = false)
    private int         floor;

    @Column(nullable = false)
    private int         simpleBed;

    @Column(nullable = false)
    private int         doubleBed;

    @Column(nullable = false)
    private int         additionalBed;

    @Column(nullable = false)
    private int         size;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_view", nullable = false)
    private RoomView    view;

    @Column(nullable = false)
    private boolean     available;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType    type;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel       hotel;

    @OneToMany(mappedBy = "room")
    private Set<Booking> bookings = new LinkedHashSet<>();

}
