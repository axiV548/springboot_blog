package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.entity.Blog;
import com.axiv548.springbootblog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * BlogService
 *
 * @date 2020/7/8 14:57
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

}


