package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.model.dto.CartDTO;
import be.technifutur.java.technisandwich.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/see")
    public CartDTO getCart(@RequestParam UUID id){
        return cartService.getCart(id);
    }

}
