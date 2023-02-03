package be.technifutur.java.timairport.mapper;

import be.technifutur.java.timairport.model.dto.FlightDTO;
import be.technifutur.java.timairport.model.entity.Flight;
import org.springframework.stereotype.Service;

@Service
public class FlightMapper {

    public FlightDTO toDto(Flight entity){
        if (entity == null)
            return null;
        return FlightDTO.builder()
                .id(entity.getId())
                .departureTime(entity.getDepartureTime())
                .arrivalTime(entity.getArrivalTime())
                .departure(FlightDTO.Flight_Airport.builder()
                        .id(entity.getDeparture().getId())
                        .name(entity.getDeparture().getName())
                        .build())
                .destination(FlightDTO.Flight_Airport.builder()
                        .id(entity.getDestination().getId())
                        .name(entity.getDestination().getName())
                        .build())
                .plane(FlightDTO.Flight_Plane.builder()
                        .id(entity.getPlane().getId())
                        .callSign(entity.getPlane().getCallSign())
                        .inMaintenance(entity.getPlane().isInMaintenance())
                        .build())
                .captain(FlightDTO.Flight_Pilot.builder()
                        .id(entity.getCaptain().getId())
                        .name(entity.getCaptain().getFirstName()+"."+entity.getCaptain().getLastName())
                        .build())
                .firstOfficer(FlightDTO.Flight_Pilot.builder()
                        .id(entity.getFirstOfficer().getId())
                        .name(entity.getFirstOfficer().getFirstName()+"."+entity.getFirstOfficer().getLastName())
                        .build())
                .cancelled(entity.isCancelled())
                .build();
    }
}
