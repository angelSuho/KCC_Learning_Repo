package com.kcc.security1.controller;

import com.kcc.security1.model.User;
import com.kcc.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/common")
    @ResponseBody
    public String common() {
        return "common";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "user";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/manager")
    @ResponseBody
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String join() {
        return "joinForm";
    }

    @PostMapping("/join")
    @ResponseBody
    public String joinPost(User user) {
        user.setRole("ROLE_USER");
        String encPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encPassword);
        User savedUser = userRepository.save(user);
        return "join";
    }
}
