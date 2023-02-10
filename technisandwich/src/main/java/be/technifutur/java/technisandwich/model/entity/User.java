package be.technifutur.java.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Getter @Setter
@Table(name = "\"user\"")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID        id;

    @Column(name = "first_name")
    private String      firstName;

    @Column(name = "last_name")
    private String      lastName;

    //must be email adresspattern
    @Column(name = "user_name", nullable = false)
    private String      username;

    @Column(name = "password", nullable = false)
    private String      password;

    @Column(name = "enabled")
    private boolean     enabled = true;

    @Column(name = "accountNonLocked")
    private boolean     accountNonLocked = true;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart        cart;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map((role) -> new SimpleGrantedAuthority("ROLE_"+role))
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
