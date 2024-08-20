package com.kcc.restful.controller;

import com.kcc.restful.bean.Post;
import com.kcc.restful.bean.User;
import com.kcc.restful.exception.UserNotFoundException;
import com.kcc.restful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
//    private final UserDaoService userDaoService;
    private final UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
//        userService.createUser(user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable(value = "id") int id) {
        User user = userService.findUser(id);

        if (user == null) {
            throw new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id));
        }

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable(value = "id") int id) {
        post.setUser_id(id);
        userService.createPost(post);
        return ResponseEntity.ok().build();
    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") int id) {
//        User user = userService.deleteById(id);
//
//        if (user == null) {
//            throw new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id));
//        }
//
//        return ResponseEntity.ok().body(user);
//    }
}
