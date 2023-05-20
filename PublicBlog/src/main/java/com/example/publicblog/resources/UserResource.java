package com.example.publicblog.resources;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.publicblog.entities.User;
import com.example.publicblog.requests.LoginRequest;
import com.example.publicblog.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/users")
public class UserResource {

    @Inject
    private UserService userService;

    public UserResource() {}

    @POST
    @Produces({"application/json"})
    @Path("/login")
    public Response findUser(LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();

        String jwt = userService.findUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (jwt == null){
            response.put("message", "Bad credentials!");
            return Response.status(422, "Unprocessable Entity").entity(response).build();
        }

        response.put("jwt", jwt);

        return Response.ok(response).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public User findUser(@PathParam("id") Integer id) {
        return userService.findUser(id);
    }

    @GET
    @Produces({"application/json"})
    @Path("/curr")
    public Response currUser(@HeaderParam("Authorization") String token) {
        if (token == null){
            return Response.status(401, "Unauthorized access, please login.").build();
        }

        User user = new User();

        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token.replace("Bearer ", ""));
        Integer userId = decodedJWT.getClaim("id").asInt();
        String username = decodedJWT.getSubject().toString();

        user.setUsername(username);
        user.setId(userId);
        return Response.ok(user).build();
    }
}
