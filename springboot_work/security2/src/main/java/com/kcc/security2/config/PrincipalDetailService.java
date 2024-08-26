package com.kcc.security2.config;

import com.kcc.security2.model.User;
import com.kcc.security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public PrincipalDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailService의 loadUserByUsername()");
        User user = userRepository.findByUsername(username)
                .orElseGet(() -> userRepository.save(User.builder()
                        .username(username)
                        .password("1234")
                        .roles("USER")
                        .build()
                ));

        return new PrincipalDetails(user);
    }
}
