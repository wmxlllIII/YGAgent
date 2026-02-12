package com.example.ygagent.data.repository;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.mapper.UserMapper;
import com.example.ygagent.data.remote.api.ApiResponse;
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
    public Result<User> login(String account, String password) {

        try {

            Response<ApiResponse<LoginRespDto>> response =
                    apiService.login(new LoginReqDto(account, password)).execute();

            if (!response.isSuccessful() || response.body() == null) {
                return Result.error("网络异常");
            }

            ApiResponse<LoginRespDto> apiResponse = response.body();

            if (!apiResponse.isSuccess()) {
                return Result.error(apiResponse.getMsg());
            }

            User user = mapper.toDomain(apiResponse.getData());

            return Result.success(user);

        } catch (IOException e) {
            return Result.error("网络异常");
        }
    }

}
