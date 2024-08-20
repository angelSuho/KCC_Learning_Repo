package com.kcc.restful.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kcc.restful.bean.AdminUser;
import com.kcc.restful.bean.User;
import com.kcc.restful.exception.UserNotFoundException;
import com.kcc.restful.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {
//    private final UserDaoService userDaoService;
    private final UserService userService;

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> users = userService.findAll();
        List<AdminUser> adminUsers = new ArrayList<>();

        for (User user : users) {
            AdminUser adminUser = new AdminUser();
            BeanUtils.copyProperties(user, adminUser);
            adminUsers.add(adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(adminUsers);
        mapping.setFilters(filters);

        return mapping;
    }

//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
//        userService.createUser(user);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable(value = "id") int id) {
        User user = userService.findUser(id);
        AdminUser adminUser = new AdminUser();

        if (user == null) {
            throw new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id));
        } else {
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "password", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") int id) {
//        User user = userDaoService.deleteById(id);
//
//        if (user == null) {
//            throw new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id));
//        }
//
//        return ResponseEntity.ok().body(user);
//    }
}
