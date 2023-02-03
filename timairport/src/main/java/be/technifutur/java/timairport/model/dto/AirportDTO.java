package be.technifutur.java.timairport.model.dto;

import be.technifutur.java.timairport.model.entity.TypePlane;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class AirportDTO {

    private UUID id;

    private String name;

    private int planeParking;

    private List<AirportAllowedType> planeTypesAllowed;

    @Data
    @Builder
    public static class AirportAllowedType{
        private UUID    id;
        private String  name;
        private int     capacity;
    }
}
