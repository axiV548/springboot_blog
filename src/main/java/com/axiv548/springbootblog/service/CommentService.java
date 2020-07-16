package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.entity.Comment;

import java.util.List;

/**
 * CommentService
 *
 * @date 2020/7/16 1:37
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
