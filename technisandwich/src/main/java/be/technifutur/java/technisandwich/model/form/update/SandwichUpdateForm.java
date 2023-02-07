package be.technifutur.java.technisandwich.model.form.update;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SandwichUpdateForm {
    private String  name;
    @Length(max = 150)
    private String  description;
    private Float   price;
}
