package com.kcc.restful.bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date(), "pass1", "701010-1111111"));
        users.add(new User(2, "Eve", new Date(), "pass2", "801010-1111111"));
        users.add(new User(3, "Jack", new Date(), "pass3", "901010-1111111"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        if (user.getJoinDate() == null) {
            user.setJoinDate(new Date());
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        User user = findOne(id);
        if (user == null) {
            return null;
        }
        if (users.remove(user)) {
            return user;
        }
        return null;
    }
}
