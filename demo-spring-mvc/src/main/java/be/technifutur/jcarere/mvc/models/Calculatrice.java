package be.technifutur.jcarere.mvc.models;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculatrice {
    @Positive
    private float   num1;
    private float   num2;
    private String  op;
}
