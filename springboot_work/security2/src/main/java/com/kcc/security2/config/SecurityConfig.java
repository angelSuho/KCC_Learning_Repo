package com.kcc.security2.config;

import com.kcc.security2.filter.JwtAuthenticationFilter;
import com.kcc.security2.filter.JwtAuthorizationFilter;
import com.kcc.security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
//    private final CorsFilter corsFilter;

    private static final String[] AUTH_WHITELIST = {
        "/h2-console/**",
        "/join",
    };

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        //http.addFilterBefore(new MyFilter01(), BasicAuthenticationFilter.class);

        http
                // csrf를 비활성화
            .csrf(AbstractHttpConfigurer::disable)
                // h2-console을 사용하기 위한 설정
                .headers(headers -> headers
                    .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )
                // form 로그인과 basic 로그인을 비활성화
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                    .requestMatchers(AUTH_WHITELIST).permitAll()
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                )
                // 세션 생성 정책을 STATELESS로 설정
                .sessionManagement(sessionManagement -> sessionManagement
                    .sessionCreationPolicy(STATELESS)
                );

        http.addFilter(new JwtAuthenticationFilter(authenticationManager))
//            .addFilter(corsFilter)
            .addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository));
        return http.build();
    }
}
