package com.example.ygagent.domain.repository;

import com.example.ygagent.domain.entity.User;

public interface UserRepository {
    User login(String account, String password) throws Exception;
}
