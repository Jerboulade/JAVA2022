package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long            id;

    @Column(name = "start_reservation", nullable = false)
    private LocalDateTime   start;

    @Column(name = "end_reservation", nullable = false)
    private LocalDateTime   end;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime   createdAt;

    @Column(name = "date_cancel")
    private LocalDateTime   cancelledAt;

    @Column(name = "additional_bed", nullable = false)
    private int             additionalBed;

    @Column(nullable = false)
    private double          price;

    private Double          discount;

    @Column(nullable = false)
    private boolean         breakfast;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer        customer;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room            room;
}
