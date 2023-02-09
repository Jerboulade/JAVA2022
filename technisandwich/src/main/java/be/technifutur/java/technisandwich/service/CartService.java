package be.technifutur.java.technisandwich.service;

import be.technifutur.java.technisandwich.model.dto.CartDTO;

import java.util.UUID;

public interface CartService {
    CartDTO getCart(UUID id);
}
