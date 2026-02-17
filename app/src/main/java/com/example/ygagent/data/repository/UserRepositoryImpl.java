package com.example.ygagent.data.repository;

import android.util.Log;

import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.core.common.Result;
import com.example.ygagent.core.network.RetrofitFactory;
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

    public static final String TAG = "YG_UserRepositoryImpl";

    private final ApiService apiService = RetrofitFactory.get().create(ApiService.class);
    private final UserMapper mapper = new UserMapper();

    @Override
    public Result<User> login(LoginType loginType, String account, String password) {

        try {
            Log.d(TAG, "[test] login  #32");

            Response<ApiResponse<LoginRespDto>> response =
                    apiService.login(new LoginReqDto(loginType, account, password)).execute();

            if (!response.isSuccessful() || response.body() == null) {
                return Result.error("网络异常");
            }

            ApiResponse<LoginRespDto> apiResponse = response.body();
            Log.d(TAG, "[test] login #35" + apiResponse);

            if (!apiResponse.isSuccess()) {
                return Result.error(apiResponse.getMsg());
            }

            User user = mapper.toDomain(apiResponse.getData());

            return Result.success(user);

        } catch (IOException e) {
            Log.d(TAG, "[x] login  #52" + e.getMessage());
            return Result.error("网络异常");
        }
    }

}
