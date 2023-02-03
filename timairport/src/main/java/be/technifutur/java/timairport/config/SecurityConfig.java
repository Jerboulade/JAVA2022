package be.technifutur.java.timairport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(

)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // configuration de sécurité
        // désactivation de certaine sécu
        http.csrf().disable();      // seulement quand on recoit un lien qui request un token identifiant
        http.httpBasic();
        http.sessionManagement()    // on est en stateless, on ne veut pas que le cookie garde les differentes session en mémoire
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /*
         * Les premiers matchers ont la priorité
         * anyRequest, s'il est mis, doit être le dernier Matcher
         *
         * RequestMatchers:
         *
         *      Lambda RequestMatchers:
         *      - prend une HttpServletRequest en param, renvoie un boolean
         *
         *      Method:
         *      - une valeur de l'enum HttpMethod
         *
         *      Pattern: 1 ou pls chaine de carac. représentant des URIs
         *      - ? :               n'imp. quel caractère
         *      - * :               n'imp. quelles valeurs dans 1 segment
         *      - {machin:regex} :  n'imp. quelles valeurs correspondant au pattern regex pour 1 segment
         *      - ** :              n'imp. quelle valeur dans 0 à N segments (seulement en dernier segment)
         *
         * Authorization:
         *      - permitAll():          tout le monde passe
         *      - denyAll():            personne ne passe
         *      - authenticated():      les users authentifiés
         *      - anonymous():          les users non authentifiés
         *      - hasAuthority(?)
         *      - hasAnyAuthority(...?)
         *      - hasRole(?)
         *      - hasAnyRole(...?)
         *
         *      Une Authority c'est un droit sous forme de String (plus un droit à une action)
         *      Un Role est une Authority qui commence par 'ROLE_' (qui est l'utilisateur pour mon app)
         *
         *      auth:   'ROLE_TRUC'   -> role: 'TRUC'
         *      auth:   'MACHIN'      -> (/) role
         */
        http.authorizeHttpRequests( (authorize) -> {
            authorize
                    //.requestMatchers(re)
                    .requestMatchers("/*/all").anonymous() // attention, le plus haut override les précédents
                    .requestMatchers(request -> request.getRequestURI().length() > 50).hasRole("ADMIN") // pour faire des truc spécifique genre , une URi composé de plus de 50 char est accessible uniquement pas un user qui a le rôle d'admin
                    .requestMatchers("/*/add").authenticated()  // * -> un segment d'URI
                    .requestMatchers("/*/delete").hasAuthority("USER") // ** -> un ou plusieur segment d'URI
                    .requestMatchers("/*/update/**").hasRole("ADMIN")
                    .requestMatchers("/*/update/**").hasAuthority("ROLE_ADMIN") //-->same as above<--
                    .requestMatchers(HttpMethod.GET, "/airport/*").hasAnyRole("USER", "ADMIN")
                    .anyRequest().permitAll();
        });

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        /*
        * UserDetails
        * -----------
        * username, password, ..
        */
        List<UserDetails> users = List.of(
                User.builder()
                        .username("user")
                        .password(encoder.encode("pass1"))
                        .roles("USER")
                        .build(),
                User.builder()
                        .username("admin")
                        .password(encoder.encode("pass2"))
                        .roles("ADMIN", "USER")
                        .build()
        );
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}