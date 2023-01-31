package be.technifutur.java.timairport.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class CompanyDTO {
    private UUID            id;
    private String          name;
    private String          originCountry;
    private List<PlaneDTO>  planes;
    private List<PilotDTO>  pilots;

    @Builder
    @Data
    public static class PlaneDTO{
        private UUID        id;
        private String      callSign;
        private boolean     inMaintenance;
    }

    @Builder
    @Data
    public static class PilotDTO{
        private UUID        id;
        private String      name;
    }

}
