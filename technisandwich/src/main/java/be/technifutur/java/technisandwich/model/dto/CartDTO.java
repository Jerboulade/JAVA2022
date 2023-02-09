package be.technifutur.java.technisandwich.model.dto;

import be.technifutur.java.technisandwich.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CartDTO {

    private UUID                id;
    //private User                user;
    private List<SandwichDTO>   sandwiches;

    @Data
    @Builder
    public static class SandwichDTO{
        private String name;
    }

}
