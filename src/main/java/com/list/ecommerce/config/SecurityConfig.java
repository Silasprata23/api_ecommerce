package com.list.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/Usuario/criarUsuario").permitAll()
                        .requestMatchers("/Produto/**").hasRole("ADMIN")
                        .requestMatchers("/pagamento/criarpagamento").hasRole("USER")
                        .requestMatchers("/Pedido/**").hasRole("USER")
                        .requestMatchers("/Usuario/deletarUsuario{id}").hasRole("ADMIN")
                        .requestMatchers("/Usuario/ListartodosUsuario").hasRole("ADMIN")
                        .requestMatchers("/Usuario/ListarUsuariopor{id}").hasRole("ADMIN")
                        .requestMatchers("/pagamento/buscarpedidoPor{id}").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )

                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
