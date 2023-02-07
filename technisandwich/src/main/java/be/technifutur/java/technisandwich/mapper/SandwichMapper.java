package be.technifutur.java.technisandwich.mapper;

import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.form.insert.SandwichInsertForm;
import org.springframework.stereotype.Service;

@Service
public class SandwichMapper {

    public SandwichDTO toDTO(Sandwich entity){
        return SandwichDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())/*
                .listCart(entity.getCart().stream()
                        .map(cart -> SandwichDTO.CartDTO.builder()
                                .username(cart.getUser().getUserName())
                                .build())
                        .toList()
                )
                .listOrder(entity.getOrder().stream()
                        .map(order -> SandwichDTO.OrderDTO.builder()
                                .username(order.getUser().getUserName())
                                .build())
                        .toList()
                )*/
                .build();
    }

    public Sandwich toEntity(SandwichInsertForm form){
        Sandwich sandwich = new Sandwich();
        sandwich.setName(form.getName());
        sandwich.setDescription(form.getDescription());
        sandwich.setPrice(form.getPrice());
        return sandwich;
    }
}
