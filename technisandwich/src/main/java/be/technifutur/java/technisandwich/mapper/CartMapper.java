package be.technifutur.java.technisandwich.mapper;

import be.technifutur.java.technisandwich.model.dto.CartDTO;
import be.technifutur.java.technisandwich.model.entity.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {

    public CartDTO toDTO(Cart entity) {
        return CartDTO.builder()
                .id(entity.getId())
                .sandwiches(entity.getSandwiches().stream()
                        .map(sandwich -> CartDTO.SandwichDTO.builder()
                                .name(sandwich.getName())
                                .build())
                        .toList()
                )
                .build();
    }
}
