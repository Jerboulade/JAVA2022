package be.technifutur.java.timairport.model.dto;

import be.technifutur.java.timairport.model.entity.Airport;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.model.entity.Plane;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class FlightDTO {

    private UUID            id;
    private LocalDateTime   departureTime;
    private LocalDateTime   arrivalTime;
    private Flight_Airport  departure;
    private Flight_Airport  destination;
    private Flight_Plane    plane;
    private Flight_Pilot    captain;
    private Flight_Pilot    firstOfficer;
    private boolean         cancelled;

    @Builder
    @Data
    public static class Flight_Airport{
        private UUID id;
        private String name;
    }

    @Builder
    @Data
    public static class Flight_Plane{
        private UUID    id;
        private String  callSign;
        private boolean inMaintenance;
    }

    @Builder
    @Data
    public static class Flight_Pilot{
        private UUID    id;
        private String  name;
    }
}
