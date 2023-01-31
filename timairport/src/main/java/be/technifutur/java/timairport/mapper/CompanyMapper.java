package be.technifutur.java.timairport.mapper;

import be.technifutur.java.timairport.model.dto.CompanyDTO;
import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyMapper {
    public CompanyDTO toDto(Company entity){
        if (entity == null)
            return null;


        return CompanyDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .originCountry(entity.getOriginCountry())
                .planes(
                        entity.getPlanes().stream()
                                .map(
                                        p -> CompanyDTO.PlaneDTO.builder()
                                                .id(p.getId())
                                                .callSign(p.getCallSign())
                                                .inMaintenance(p.isInMaintenance())
                                                .build()
                                )
                                .toList()
                )
                .pilots(
                        entity.getPilots().stream()
                                .map(
                                        pilot -> CompanyDTO.PilotDTO.builder()
                                                .id(pilot.getId())
                                                .name(pilot.getFirstName() +"."+ pilot.getLastName())
                                                .build()
                                )
                                .toList()

                )
                .build();
    }
}
