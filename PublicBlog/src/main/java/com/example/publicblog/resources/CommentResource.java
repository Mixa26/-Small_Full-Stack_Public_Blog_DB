package com.example.publicblog.resources;

import com.example.publicblog.entities.Comment;
import com.example.publicblog.services.CommentService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

@Path("/comments")
public class CommentResource {

    @Inject
    private CommentService commentService;

    public CommentResource(){}

    @POST
    @Produces({"application/json"})
    public Comment addComment(@Valid Comment comment) {return commentService.addComment(comment);}

    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public List<Comment> allComments(@PathParam("id") Integer blogId) {return commentService.allComments(blogId);}

}
