package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.entity.User;
import com.axiv548.springbootblog.sql.UserRepository;
import com.axiv548.springbootblog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @date 2020/7/4 17:23
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Util.code(password));
        return user;
    }

}
