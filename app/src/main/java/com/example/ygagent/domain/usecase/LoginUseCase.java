package com.example.ygagent.domain.usecase;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.repository.UserRepository;

public class LoginUseCase {
    private final UserRepository repository;

    public LoginUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public Result<User> execute(String account, String password) {

        if (account == null || account.isEmpty()) {
            return Result.error("账号不能为空");
        }

        return repository.login(account, password);
    }

}
