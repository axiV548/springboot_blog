package com.axiv548.springbootblog.sql;

import com.axiv548.springbootblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @date 2020/7/4 17:25
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}
