package be.technifutur.jcarere.mvc.models.form;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class HotelForm {
    @NotNull
    private String  id;
    @NotBlank
    @Size(max = 100)
    private String  name;
    @NotBlank
    private String  address;
    @PositiveOrZero
    @Max(5)
    private int     stars;
    @Size(max = 100)
    private String  groom;
}
