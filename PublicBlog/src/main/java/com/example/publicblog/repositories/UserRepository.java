package com.example.publicblog.repositories;

import com.example.publicblog.entities.User;

public interface UserRepository {

    boolean findUser(String username, String password);

    User findUser(String username);

    User findUser(Integer id);
}
