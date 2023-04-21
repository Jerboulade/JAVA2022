package be.technifutur.java.roombook.mappers;

import be.technifutur.java.roombook.dtos.RoomDTO;
import be.technifutur.java.roombook.dtos.UserDTO;
import be.technifutur.java.roombook.models.entity.Room;
import be.technifutur.java.roombook.models.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO toDTO(User entity){
        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }
}
