package be.technifutur.java.technisandwich.model.form.authentication;


import be.technifutur.java.technisandwich.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter @Setter
public class RegistrationForm {
    @NotNull
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

}
