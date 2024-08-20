package com.kcc.restful.service;

import com.kcc.restful.bean.Post;
import com.kcc.restful.bean.User;
import com.kcc.restful.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAllUsers();
    }

    public User findUser(int id) {
        return userMapper.findUser(id);
    }

    public void createUser(User user) {
        userMapper.createUser(user);
    }

    public void createPost(Post post) {
        userMapper.createPost(post);
    }
}
