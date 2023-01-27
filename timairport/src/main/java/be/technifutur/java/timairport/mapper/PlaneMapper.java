package be.technifutur.java.timairport.mapper;

import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.entity.Plane;
import org.springframework.stereotype.Service;

@Service
public class PlaneMapper {
    public PlaneDTO toDto(Plane entity){
        if (entity == null)
            return null;
        return PlaneDTO.builder()
                .id(entity.getId())
                .inMaintenance(entity.isInMaintenance())
                .callSign(entity.getCallSign())
                .registrationDate(entity.getRegistrationDate())
                .company(
                        PlaneDTO.CompanyDTO.builder()
                                .id(entity.getCompany().getId())
                                .name(entity.getCompany().getName())
                                .originCountry(entity.getCompany().getOriginCountry())
                                .build()
                )
                .type(
                        PlaneDTO.TypeDTO.builder()
                                .id(entity.getType().getId())
                                .name(entity.getType().getName())
                                .capacity(entity.getType().getCapacity())
                                .build()
                )
                .build();
    }
}
