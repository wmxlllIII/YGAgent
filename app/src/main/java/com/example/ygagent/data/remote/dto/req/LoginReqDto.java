package com.example.ygagent.data.remote.dto.req;

import com.example.ygagent.common.constants.LoginType;

public class LoginReqDto {
    private LoginType loginType;
    private String account;
    private String password;

    public LoginReqDto(LoginType loginType, String account, String password) {
        this.loginType = loginType;
        this.account = account;
        this.password = password;
    }
}
