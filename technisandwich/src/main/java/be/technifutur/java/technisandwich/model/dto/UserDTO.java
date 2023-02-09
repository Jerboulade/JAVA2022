package be.technifutur.java.technisandwich.model.dto;

import be.technifutur.java.technisandwich.model.entity.Cart;
import be.technifutur.java.technisandwich.model.entity.Order;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserDTO {

    private UUID        id;
    /*
    private String      firstName;
    private String      lastName;
    private String      userName;
    private boolean     enabled;
    private boolean     blacklisted;
     */
    private UUID        cart_id;
    //private List<Order> order;
}
