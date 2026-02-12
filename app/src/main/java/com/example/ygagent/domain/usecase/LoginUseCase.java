package com.example.ygagent.domain.usecase;

import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.repository.UserRepository;

public class LoginUseCase {
    private final UserRepository repository;

    public LoginUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String account, String password) throws Exception {

        if (account == null || account.isEmpty()) {
            throw new IllegalArgumentException("账号不能为空");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("密码不能为空");
        }

        return repository.login(account, password);
    }
}
