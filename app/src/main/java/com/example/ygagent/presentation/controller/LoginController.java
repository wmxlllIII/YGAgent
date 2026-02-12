package com.example.ygagent.presentation.controller;

import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.usecase.LoginUseCase;

public class LoginController {
    public interface Callback {
        void onSuccess(User user);
        void onError(String msg);
    }

    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public void login(String account, String password, Callback callback) {

        new Thread(() -> {
            try {
                User user = loginUseCase.execute(account, password);
                callback.onSuccess(user);
            } catch (Exception e) {
                callback.onError(e.getMessage());
            }
        }).start();
    }
}
