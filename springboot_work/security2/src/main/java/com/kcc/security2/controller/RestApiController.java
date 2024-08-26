package com.kcc.security2.controller;

import com.kcc.security2.model.User;
import com.kcc.security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApiController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return ("<h1>HOME</h1>");
    }

    @PostMapping("/join")
    public String join(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_ADMIN");
        userRepository.save(user);
        return "회원가입 완료";
    }

    @GetMapping("/manager/mm")
    public String manager() {
        return "manager";
    }

    @GetMapping("/admin/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user/user")
    public String user() {
        return "user";
    }
}
