package com.example.ygagent.data.repository;

import com.example.ygagent.data.mapper.UserMapper;
import com.example.ygagent.data.remote.api.ApiService;
import com.example.ygagent.data.remote.dto.req.LoginReqDto;
import com.example.ygagent.data.remote.dto.resp.LoginRespDto;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.repository.UserRepository;

import java.io.IOException;

import retrofit2.Response;

public class UserRepositoryImpl implements UserRepository {

    private final ApiService apiService;
    private final UserMapper mapper = new UserMapper();

    public UserRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }
    @Override
    public User login(String account, String password) {
        try {

            LoginReqDto req = new LoginReqDto(account, password);

            Response<LoginRespDto> response =
                    apiService.login(req).execute();

            if (!response.isSuccessful() || response.body() == null) {
                throw new RuntimeException("登录失败");
            }

            return mapper.toDomain(response.body());

        } catch (IOException e) {
            throw new RuntimeException("网络异常", e);
        }
    }
}
