package com.example.publicblog.requests;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(){}

    public LoginRequest(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
