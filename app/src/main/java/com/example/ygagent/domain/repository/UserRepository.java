package com.example.ygagent.domain.repository;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.domain.entity.User;

public interface UserRepository {
    Result<User> login(String account, String password);
}
