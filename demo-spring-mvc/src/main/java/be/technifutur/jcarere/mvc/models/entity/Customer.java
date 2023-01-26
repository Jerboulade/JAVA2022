package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Customer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long            id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(nullable = false)
    private String          password;

    @Column(nullable = false)
    private String          role;

    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookings = new LinkedHashSet<>();
}
