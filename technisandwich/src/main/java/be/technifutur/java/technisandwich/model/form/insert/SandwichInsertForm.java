package be.technifutur.java.technisandwich.model.form.insert;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SandwichInsertForm {

    @NotNull
    private String  name;
    @Length(max = 150, message = "Some description")
    private String  description;
    @NotNull
    private Float   price;
}
