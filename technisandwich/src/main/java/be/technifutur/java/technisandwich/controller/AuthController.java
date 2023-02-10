package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.jwt.JwtHolder;
import be.technifutur.java.technisandwich.model.form.authentication.LoginForm;
import be.technifutur.java.technisandwich.model.form.authentication.RegistrationForm;
import be.technifutur.java.technisandwich.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public void         userRegistration(@RequestBody @Valid RegistrationForm form){
        authService.userRegistration(form);
    }

    @PostMapping("/signin")
    public JwtHolder    userLogin(@RequestBody @Valid LoginForm form){
        return authService.userLogin(form);
    }
}
