package be.technifutur.java.technisandwich.service;

import be.technifutur.java.technisandwich.jwt.JwtHolder;
import be.technifutur.java.technisandwich.model.form.authentication.LoginForm;
import be.technifutur.java.technisandwich.model.form.authentication.RegistrationForm;

public interface AuthService {
    void userRegistration(RegistrationForm form);

    JwtHolder userLogin(LoginForm form);
}
