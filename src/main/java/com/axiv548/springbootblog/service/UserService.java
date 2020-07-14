package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.entity.User;

/**
 * UserService
 *
 * @date 2020/7/4 17:22
 */
public interface UserService {

    User checkUser(String username, String password);
}
