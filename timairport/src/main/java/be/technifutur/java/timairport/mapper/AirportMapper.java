package be.technifutur.java.timairport.mapper;

import be.technifutur.java.timairport.model.dto.AirportDTO;
import be.technifutur.java.timairport.model.dto.CompanyDTO;
import be.technifutur.java.timairport.model.entity.Airport;
import be.technifutur.java.timairport.model.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class AirportMapper {

    public AirportDTO toDto(Airport entity){
        if (entity == null)
            return null;
        return AirportDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .planeParking(entity.getPlaneParking())
                .planeTypesAllowed(
                        entity.getPlaneTypesAllowed().stream()
                                .map(type -> AirportDTO.AirportAllowedType.builder()
                                        .id(type.getId())
                                        .name(type.getName())
                                        .capacity(type.getCapacity())
                                        .build())
                                .toList()
                )
                .build();
    }
}
