package com.example.ygagent.domain.entity;

public class User {

    private final long id;
    private final String username;
    private final String token;

    public User(long id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public long getId() { return id; }
    public String getUsername() { return username; }
    public String getToken() { return token; }
}

