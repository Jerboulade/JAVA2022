package be.technifutur.java.technisandwich.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SandwichDTO {
    private Long    id;
    private String  name;
    private String  description;
    private Float   price;
}
