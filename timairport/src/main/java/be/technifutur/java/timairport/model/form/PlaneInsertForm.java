package be.technifutur.java.timairport.model.form;

import be.technifutur.java.timairport.constraint.PilotXp;
import be.technifutur.java.timairport.model.entity.Plane;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PlaneInsertForm {
    @NotNull
    @Pattern(regexp = "[A-Z]-[A-Z]{4}|[A-Z]{2}-[A-Z]{3}|N[0-9]{1,5}[A-Z]{0,2}")
    private String callSign;

    @NotNull
    @PastOrPresent
    private LocalDate registrationDate;

    @NotNull
    private UUID companyId;

    @NotNull
    private UUID typeId;

    public Plane toEntity(){
        Plane entity = new Plane();

        entity.setCallSign(this.callSign);
        entity.setRegistrationDate(this.registrationDate);

        return entity;
    }
}
