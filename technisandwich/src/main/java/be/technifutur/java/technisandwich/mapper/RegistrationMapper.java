package be.technifutur.java.technisandwich.mapper;

import be.technifutur.java.technisandwich.model.entity.Cart;
import be.technifutur.java.technisandwich.model.entity.User;
import be.technifutur.java.technisandwich.model.form.authentication.RegistrationForm;
import be.technifutur.java.technisandwich.repository.CartRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RegistrationMapper {
    private final PasswordEncoder passwordEncoder;
    private final CartRepository  cartRepository;

    public RegistrationMapper(PasswordEncoder passwordEncoder, CartRepository cartRepository) {
        this.passwordEncoder = passwordEncoder;
        this.cartRepository = cartRepository;
    }

    public User toUser(RegistrationForm form){
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setCart(cartRepository.save(new Cart()));
        user.setRoles(Set.of("USER"));
        return user;
    }
}
