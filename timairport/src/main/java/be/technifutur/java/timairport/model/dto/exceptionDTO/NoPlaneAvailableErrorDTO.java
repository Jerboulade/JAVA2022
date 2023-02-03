package be.technifutur.java.timairport.model.dto.exceptionDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NoPlaneAvailableErrorDTO {
    private String  method;
    private String  path;
    private String  message;
    private int     status;
}
