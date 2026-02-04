package com.example.ygagent.model.dto.resp;

public class LoginDto {
    private long userId;
    private String username;
    private String token;

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
