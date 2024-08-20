package com.kcc.restful.mapper;

import com.kcc.restful.bean.Post;
import com.kcc.restful.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface UserMapper {
    List<User> findAllUsers();
    User findUser(int id);
    void createUser(User user);
    void createPost(Post post);

}
