package be.technifutur.java.technisandwich.model.dto;

import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDTO {

    private UUID                id;
    private LocalDate           orderDate;
    private LocalDate           deliveryDate;
    private float               discount;
    private boolean             state;
    //private UserDTO             user;
    private List<SandwichDTO>   sandwiches;

    @Data
    @Builder
    public static class SandwichDTO{
        private Long    id;
        private String  name;
    }

    @Data
    @Builder
    public static class UserDTO{
        //private Long    id;
        private String  firstName;
    }
}
