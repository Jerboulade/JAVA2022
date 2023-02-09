package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID        id;

    @Column(name = "first_name")
    private String      firstName;

    @Column(name = "last_name")
    private String      lastName;

    //must be email adresspattern
    @Column(name = "user_name")
    private String      userName;

    @Column(name = "enabled")
    private boolean     enabled = true;

    @Column(name = "blacklisted")
    private boolean     blacklisted = false;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart        cart;

    @OneToMany(mappedBy = "user")
    private List<Order> order;


}
