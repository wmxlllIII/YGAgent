package com.example.ygagent.presentation.controller;

import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.usecase.LoginUseCase;

public class LoginController {

    public static final String TAG = "YG_LoginController";

    private final LoginUseCase loginUseCase = new LoginUseCase();

    public interface Callback {
        void onSuccess(User user);

        void onError(String msg);
    }

    public void login(LoginType loginType, String account, String password, Callback callback) {
        new Thread(() -> {
            try {
                User user = loginUseCase.execute(loginType, account, password).getData();
                callback.onSuccess(user);
            } catch (Exception e) {
                callback.onError(e.getMessage());
            }
        }).start();
    }
}
