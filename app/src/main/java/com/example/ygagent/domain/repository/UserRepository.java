package com.example.ygagent.domain.repository;

import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.core.common.Result;
import com.example.ygagent.domain.entity.User;

public interface UserRepository {
    Result<User> login(LoginType loginType, String account, String password);
}
