package be.technifutur.jcarere.mvc.models;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DemoValidationForm {

    // Si le client ne respecte pas les validations de format --> error 400
    @Min(15) //included
    @Max(50) //included
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    private int             entier;

    @NotBlank // empty string or onr whitespaces
    @NotNull
    @NotEmpty
    @Null
    @Size(min = 0, max = 10)
    @Pattern(regexp = "[0-9]+")
    private String          str;

    @NotNull
    @Null
    private Object          object;

    @NotNull
    @NotEmpty
    @Null
    @Size(min = 0, max = 50)
    private List<Object>    list;

    @NotNull
    @Null
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent
    private LocalDateTime   date;


}
