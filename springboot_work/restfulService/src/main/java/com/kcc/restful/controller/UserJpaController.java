//package com.kcc.restful.controller;
//
//import com.kcc.restful.bean.Post;
//import com.kcc.restful.bean.User;
//import com.kcc.restful.exception.UserNotFoundException;
//import com.kcc.restful.repository.PostRepository;
//import com.kcc.restful.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//public class UserJpaController {
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUserById(int id) {
//        userRepository.deleteById(id);
//    }
//
//    @GetMapping("/users/{id}/posts")
//    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.isEmpty()) {
//            throw new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id));
//        }
//
//        return user.get().getPosts();
//    }
//
//    @PostMapping("/users/{id}/posts")
//    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.isEmpty()) {
//            throw new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id));
//        }
//
//        post.setUser(user.get());
//        postRepository.save(post);
//        return ResponseEntity.ok().body(post);
//    }
//
//    @GetMapping("/users/{id}/posts/{postId}")
//    public Post retrievePost(@PathVariable int id, @PathVariable int postId) {
//        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("ID[%s] not found", id)));
//        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND, String.format("Post ID[%s] not found", postId)));
//        return post;
//    }
//}
