package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID        id;

    @Column(name = "first_name", nullable = false)
    private String      firstName;

    @Column(name = "last_name", nullable = false)
    private String      lastName;

    //must be email adresspattern
    @Column(name = "user_name", nullable = false)
    private String      userName;

    @Column(name = "enabled", nullable = false)
    private boolean     enabled = true;

    @Column(name = "blacklisted", nullable = false)
    private boolean     blacklisted = false;

    @OneToOne
    @JoinColumn(name = "cart_id", unique = true)
    private Cart        cart;

    @OneToMany(mappedBy = "user")
    private List<Order> order;


}
