package be.technifutur.java.timairport.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

// ce que le client va recevoir comme données
@Data
@Builder
public class PilotDTO {
    private UUID id;
    private String  name;

}
