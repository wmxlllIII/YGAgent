package com.example.ygagent.data.mapper;

import com.example.ygagent.data.remote.dto.resp.LoginRespDto;
import com.example.ygagent.domain.entity.User;

public class UserMapper {

    public User toDomain(LoginRespDto dto) {
        return new User(
                dto.getUserId(),
                dto.getUsername(),
                dto.getToken()
        );
    }
}
