//package com.kcc.restful.bean;
//
//import com.kcc.restful.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class UserDaoService {
//    private final UserRepository userRepository;
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Transactional
//    public User save(User user) {
//
//        if (user.getJoinDate() == null) {
//            user.setJoinDate(new Date());
//        }
//
//        userRepository.save(user);
//        return user;
//    }
//
//    public User findOne(int id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    @Transactional
//    public User deleteById(int id) {
//        User user = userRepository.findById(id).orElse(null);
//        userRepository.deleteById(id);
//        return user;
//    }
//}
