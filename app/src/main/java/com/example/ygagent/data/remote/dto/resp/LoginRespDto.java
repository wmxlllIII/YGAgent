package com.example.ygagent.data.remote.dto.resp;

public class LoginRespDto {
    private long userId;
    private String username;
    private String token;

    public long getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getToken() { return token; }

    @Override
    public String toString() {
        return "LoginRespDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
