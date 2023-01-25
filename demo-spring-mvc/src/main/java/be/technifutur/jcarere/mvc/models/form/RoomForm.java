package be.technifutur.jcarere.mvc.models.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RoomForm {
    @Positive
    private int     roomNumber;
    @Positive
    private int     roomSize;
    @Positive
    private int     nbSimpleBed;
    @Positive
    private int     nbDoubleBed;
    @NotNull
    private String  hotelId;
}
