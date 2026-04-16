package grupo10.tpo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Es una protección contra ataques en formularios web. Pero en API la desabilitamos.
            .authorizeHttpRequests(auth -> auth //se define quien accede
                .requestMatchers("/usuarios/registro").permitAll()
                .anyRequest().authenticated() //si necesita login
            )
            .httpBasic(withDefaults()); // 👈 ACÁ

        return http.build();
    }
}