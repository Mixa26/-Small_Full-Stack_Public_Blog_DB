package com.example.publicblog.entities;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "Id must be present!")
    private Integer id;

    @NotNull(message = "Username can't be empty!")
    private String username;

    @NotNull(message = "Password can't be empty!")
    private String password;

    public User(){}

    public User(Integer id, String username, String password) {
        this();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
