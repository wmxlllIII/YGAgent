package com.example.ygagent.model.mapper;

import com.example.ygagent.model.domain.User;
import com.example.ygagent.model.dto.resp.LoginDto;

public class UserMapper {

    public static User toDomain(LoginDto dto) {
        User u = new User();
        u.setId(dto.getUserId());
        u.setName(dto.getUsername());
        u.setToken(dto.getToken());
        return u;
    }

}
