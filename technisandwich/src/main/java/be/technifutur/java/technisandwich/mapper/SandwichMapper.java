package be.technifutur.java.technisandwich.mapper;

import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.form.SandwichForm;
import org.springframework.stereotype.Service;

@Service
public class SandwichMapper {

    public SandwichDTO toDTO(Sandwich entity){
        return SandwichDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

    public Sandwich toEntity(SandwichForm form){
        Sandwich sandwich = new Sandwich();
        sandwich.setName(form.getName());
        sandwich.setDescription(form.getDescription());
        sandwich.setPrice(form.getPrice());
        return sandwich;
    }
}
