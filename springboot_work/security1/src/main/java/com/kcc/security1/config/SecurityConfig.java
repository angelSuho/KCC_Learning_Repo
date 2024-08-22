package com.kcc.security1.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> {
                csrf.ignoringRequestMatchers(PathRequest.toH2Console());
                csrf.disable();
            })
            .headers(headers -> {
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
            })
            .authorizeRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/h2-console/**").permitAll()
                            .requestMatchers("/common/**").permitAll()
                            .requestMatchers("/user/**").hasRole("ROLE_USER")
                            .requestMatchers("/admin/**").hasRole("ROLE_ADMIN")
                            .requestMatchers("/manager/**").hasAnyRole("ROLE_MANAGER", "ROLE_ADMIN")
                            .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                    formLogin
                            .loginPage("/loginForm")
                            .defaultSuccessUrl("/main")
                            .loginProcessingUrl("/login")
                            .failureUrl("/loginForm?error")
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
