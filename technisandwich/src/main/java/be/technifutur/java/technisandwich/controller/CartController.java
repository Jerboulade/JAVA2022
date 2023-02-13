package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.model.dto.CartDTO;
import be.technifutur.java.technisandwich.model.entity.User;
import be.technifutur.java.technisandwich.service.CartService;
import be.technifutur.java.technisandwich.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final UserDetailsService userDetailsService;
    private final UserService userService;

    public CartController(CartService cartService, UserDetailsService userDetailsService, UserService userService) {
        this.cartService = cartService;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping("/see")
    public CartDTO getCart(Authentication auth) {
        String username = auth.getPrincipal().toString();
        User user = (User) userDetailsService.loadUserByUsername(username);
        return cartService.getCart(user.getCart().getId());
    }

}
