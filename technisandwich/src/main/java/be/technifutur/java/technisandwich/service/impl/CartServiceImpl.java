package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.mapper.CartMapper;
import be.technifutur.java.technisandwich.model.dto.CartDTO;
import be.technifutur.java.technisandwich.repository.CartRepository;
import be.technifutur.java.technisandwich.service.CartService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository    cartRepository;
    private final CartMapper        cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartDTO getCart(UUID id) {
        return cartMapper.toDTO(cartRepository.findById(id).orElseThrow());
    }
}
