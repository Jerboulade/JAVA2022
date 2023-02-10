package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.jwt.JwtHolder;
import be.technifutur.java.technisandwich.jwt.JwtProvider;
import be.technifutur.java.technisandwich.mapper.RegistrationMapper;
import be.technifutur.java.technisandwich.model.entity.User;
import be.technifutur.java.technisandwich.model.form.authentication.LoginForm;
import be.technifutur.java.technisandwich.model.form.authentication.RegistrationForm;
import be.technifutur.java.technisandwich.repository.UserRepository;
import be.technifutur.java.technisandwich.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtProvider           jwtProvider;
    private final UserRepository        userRepository;
    private final AuthenticationManager authenticationManager;
    private final RegistrationMapper    registrationMapper;

    public AuthServiceImpl(JwtProvider jwtProvider, UserRepository userRepository, AuthenticationManager authenticationManager, RegistrationMapper registrationMapper) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.registrationMapper = registrationMapper;
    }

    @Override
    public void userRegistration(RegistrationForm form) {
        if (userRepository.existsByUsername(form.getUsername()))
            throw new RuntimeException("Username already exists!");
        User user = registrationMapper.toUser(form);
        userRepository.save(user);
    }

    @Override
    public JwtHolder userLogin(LoginForm form) {
        Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        auth = authenticationManager.authenticate(auth);
        return new JwtHolder(jwtProvider.createToken(auth));
    }
}
