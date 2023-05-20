package com.example.publicblog.resources;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.publicblog.entities.Blog;
import com.example.publicblog.services.BlogService;
import com.example.publicblog.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/blogs")
public class BlogResource {

    @Inject
    private BlogService blogService;

    public BlogResource(){}

    @GET
    @Produces({"application/json"})
    public Response allBlogs() {return Response.ok(blogService.allBlogs()).build();}

    @POST
    @Produces({"application/json"})
    public Response create(@Valid Blog blog, @HeaderParam("Authorization") String token) {
        if (token == null){
            return Response.status(401, "Unauthorized access, please login.").build();
        }

        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token.replace("Bearer ", ""));
        Integer userId = decodedJWT.getClaim("id").asInt();
        String username = decodedJWT.getSubject().toString();

        blog.setAuthor(username);
        blog.setUserId(userId);

        return Response.ok(blogService.addBlog(blog)).build();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Blog find(@PathParam("id") Integer id) {return blogService.findBlog(id);}
}
