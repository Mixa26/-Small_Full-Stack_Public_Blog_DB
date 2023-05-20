package com.example.publicblog.services;

import com.example.publicblog.entities.Comment;
import com.example.publicblog.repositories.CommentRepository;

import javax.inject.Inject;
import java.util.List;

public class CommentService {

    @Inject
    private CommentRepository commentRepository;

    public CommentService(){}

    public Comment addComment(Comment comment){return commentRepository.addComment(comment);}

    public List<Comment> allComments(Integer blogId){return commentRepository.allComments(blogId);}
}
