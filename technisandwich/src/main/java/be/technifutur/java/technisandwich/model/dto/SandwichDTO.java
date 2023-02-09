package be.technifutur.java.technisandwich.model.dto;

import be.technifutur.java.technisandwich.model.entity.Cart;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class SandwichDTO {
    private Long    id;
    private String  name;
    private String  description;
    private Float   price;

    // vérif
    private List<CartDTO> listCart;
    private List<OrderDTO> listOrder;

    @Data
    @Builder
    public static class CartDTO {
        private String username;
    }
    @Data
    @Builder
    public static class OrderDTO {
        //private String username;
        private UUID id;

    }
}
