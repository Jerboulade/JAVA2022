package be.technifutur.java.timairport.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class PlaneDTO {
    private UUID        id;
    private String      callSign;
    private LocalDate   registrationDate;
    private boolean     inMaintenance;
    private TypeDTO     type;
    private CompanyDTO  company;

    // class interne parce qu'elle a un interêt pour cette classe;
    @Data
    @Builder // optionel
    public static class TypeDTO{
        private UUID    id;
        private String  name;
        private int     capacity;
    }
    @Data
    @Builder // optionel
    public static class CompanyDTO{
        private UUID    id;
        private String  name;
        private String  originCountry;
    }
}
