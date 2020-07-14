package com.axiv548.springbootblog.sql;

import com.axiv548.springbootblog.entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TypesRepository
 *
 * @date 2020/7/4 23:29
 */
public interface TypesRepository extends JpaRepository<Types, Long> {

    Types findByName(String name);

}
