package com.example.ygagent.data.remote.dto.req;

public class LoginReqDto {
    private String account;
    private String password;

    public LoginReqDto(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
