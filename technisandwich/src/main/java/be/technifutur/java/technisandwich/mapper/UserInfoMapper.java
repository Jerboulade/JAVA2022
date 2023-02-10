package be.technifutur.java.technisandwich.mapper;

import be.technifutur.java.technisandwich.model.dto.UserDTO;
import be.technifutur.java.technisandwich.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMapper {
    public UserDTO toDTO(User entity){
        return UserDTO.builder()
                .id(entity.getId())
                .cart_id(entity.getCart().getId())
                .build();
    }
}
