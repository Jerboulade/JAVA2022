package be.technifutur.java.roombook.services;

import be.technifutur.java.roombook.dtos.AuthDTO;
import be.technifutur.java.roombook.models.form.LoginForm;

public interface AuthService {

    AuthDTO login(LoginForm form);
}
