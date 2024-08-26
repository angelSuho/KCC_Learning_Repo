package com.kcc.security1.config;

import com.kcc.security1.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;

    private static final String[] WHITE_LIST = {
            "/h2-console/**",
            "/WEB-INF/views/**",
            "/",
            "/common/**",
            "/loginForm",
            "/joinForm",
    };

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
                            .requestMatchers(WHITE_LIST).permitAll()
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
                            .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                    formLogin
                            .loginPage("/loginForm")
                            .defaultSuccessUrl("/main")
                            .loginProcessingUrl("/login")
                            .failureUrl("/loginForm?error")
            )
            .oauth2Login(oauth2Login ->
                    oauth2Login
                            .loginPage("/loginForm")
                            .userInfoEndpoint(userInfoEndpoint ->
                                    userInfoEndpoint.userService(principalOauth2UserService)
                            )
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
