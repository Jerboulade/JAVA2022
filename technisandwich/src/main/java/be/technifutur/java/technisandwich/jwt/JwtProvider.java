package be.technifutur.java.technisandwich.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JwtProvider {

    private final UserDetailsService userDetailsService;

    public JwtProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(Authentication auth) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(System.currentTimeMillis() + (24*60*60*1000));

        try {
            return JWT.create()
                    .withSubject(auth.getName())
                    .withIssuedAt(issuedAt)
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC512("s3cr3t"));
        } catch (UnsupportedEncodingException e){
            throw new RuntimeException("BIP BOUP internal error BIIIIIIP", e);
        }
    }

    public boolean validateToken(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512("s3cr3t"))
                    .acceptExpiresAt(24*60*60*1000)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return true;
        }
        catch (JWTVerificationException verificationException) {
            return false;
        }
        catch (UnsupportedEncodingException exception) {
            throw new RuntimeException("BIP BOUP internal error BIIIIIIP", exception);
        }
    }

    public Authentication generateAuth(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return UsernamePasswordAuthenticationToken.authenticated(username,
                null,
                userDetails.getAuthorities());
    }

}
