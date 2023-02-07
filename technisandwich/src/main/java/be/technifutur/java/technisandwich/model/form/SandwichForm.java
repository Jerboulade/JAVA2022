package be.technifutur.java.technisandwich.model.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SandwichForm {

    @NotNull
    private String  name;
    @Length(max = 150, message = "Some description")
    private String  description;
    @NotNull
    private Float   price;
}
