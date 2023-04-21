package be.technifutur.java.roombook.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RoomDTO {

    private UUID id;
    private Integer number;
    private Integer capacity;

}
