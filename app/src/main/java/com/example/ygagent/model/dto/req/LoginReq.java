package com.example.ygagent.model.dto.req;

public class LoginReq {
    private String account;
    private String password;

    public LoginReq(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
