package be.technifutur.java.timairport.model.form;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FlightUpdateScheduleForm {
    @NotNull
    private UUID id;
    @NotNull
    @Future
    private LocalDateTime departureTime;
    @NotNull
    @Future
    private LocalDateTime arrivalTime;
}
