package com.example.ygagent.domain.usecase;

import android.util.Log;

import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.repository.UserRepositoryImpl;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.repository.UserRepository;

public class LoginUseCase {

    public static final String TAG = "YG_LoginUseCase";

    private final UserRepository repository = new UserRepositoryImpl();

    public Result<User> execute(LoginType loginType, String account, String password) {
        Log.d(TAG, "[test] initView  #32");

        if (account == null || account.isEmpty()) {
            return Result.error("账号不能为空");
        }

        return repository.login(loginType,account, password);
    }

}
