package com.project.web.SweetCRUD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
           auth.requestMatchers("/auth/**").permitAll();
           auth.requestMatchers("/videos/**").permitAll();
           auth.requestMatchers("/maintenance/**").authenticated();
        });

        http.formLogin(form -> {
           form.loginPage("/auth/login").permitAll();
           form.defaultSuccessUrl("/maintenance/start", true);
        });

        http.logout(logout -> {
           logout.logoutUrl("/maintenance/logout").permitAll();
           logout.logoutSuccessUrl("/auth/login?logout");
        });

        return http.build();
    }
}
