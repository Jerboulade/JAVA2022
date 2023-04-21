package be.technifutur.java.roombook.services.impl;

import be.technifutur.java.roombook.dtos.AuthDTO;
import be.technifutur.java.roombook.models.form.LoginForm;
import be.technifutur.java.roombook.services.AuthService;
import be.technifutur.java.roombook.utils.JWTProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTProvider           jwtProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthDTO login(LoginForm form) {
        Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        authenticationManager.authenticate(auth);
        return new AuthDTO(jwtProvider.createToken(auth), auth.getName());
        // a ce point-ci, l'objet Authentication est pas complet (contient username, password, est valide, c'est tout)

    }
}
