package com.example.publicblog.repositories;

import com.example.publicblog.entities.Comment;

import java.util.List;

public interface CommentRepository {

    Comment addComment(Comment comment);

    List<Comment> allComments(Integer blogId);
}
