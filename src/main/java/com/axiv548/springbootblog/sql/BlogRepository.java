package com.axiv548.springbootblog.sql;

import com.axiv548.springbootblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * BlogRepository
 *
 * @date 2020/7/8 15:01
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
}
