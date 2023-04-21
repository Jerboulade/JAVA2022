package be.technifutur.java.roombook.mappers;

import be.technifutur.java.roombook.dtos.RoomDTO;
import be.technifutur.java.roombook.models.entity.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {

    public RoomDTO toDTO(Room entity){
        return RoomDTO.builder()
                .id(entity.getId())
                .capacity(entity.getCapacity())
                .number(entity.getNumber())
                .build();
    }
}
