package be.technifutur.java.timairport.model.form;

import be.technifutur.java.timairport.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class LoginForm {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
