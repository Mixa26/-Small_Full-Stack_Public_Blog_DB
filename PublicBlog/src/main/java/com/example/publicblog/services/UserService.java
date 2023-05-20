package com.example.publicblog.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.publicblog.entities.User;
import com.example.publicblog.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import java.util.Date;

public class UserService {

    @Inject
    private UserRepository userRepository;

    public UserService(){}

    public String findUser(String username, String password){
        //String hashedPassword = DigestUtils.sha256Hex(password);

        if (!userRepository.findUser(username, password)){
            return null;
        }

        Integer id = userRepository.findUser(username).getId();

        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + 24*60*60*1000);

        Algorithm algorithm = Algorithm.HMAC256("secret");

        return JWT.create()
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withSubject(username)
                .withClaim("id", id)
                .sign(algorithm);
    }

    public User findUser(Integer id){
        return userRepository.findUser(id);
    }

    public boolean isAuthorized(String token){
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        String username = jwt.getSubject();
//        jwt.getClaim("role").asString();

        User user = this.userRepository.findUser(username);

        if (user == null){
            return false;
        }

        return true;
    }
}
