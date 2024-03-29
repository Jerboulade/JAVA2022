package be.technifutur.java.roombook.config;

import be.technifutur.java.roombook.utils.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTProvider jwtProvider;

    public JWTAuthFilter(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1) sortir le token de la requête
        String token = jwtProvider.extractToken(request);

        // 2) valider le token
        if (token != null && jwtProvider.validateToken(token)){
            // 3) s'il est valide, créer l'Authentication
            Authentication auth = jwtProvider.createAuth(token);
            // 4) mettre l'Authentication dans le SecurityContext
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);

    }
}
