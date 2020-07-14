package com.axiv548.springbootblog.sql;

import com.axiv548.springbootblog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TagRepository
 *
 * @date 2020/7/10 21:05
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);
}
