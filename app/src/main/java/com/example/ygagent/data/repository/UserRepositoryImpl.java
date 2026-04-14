package com.example.ygagent.data.repository;

import android.util.Log;

import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.core.common.Result;
import com.example.ygagent.core.network.NetFactory;
import com.example.ygagent.core.network.RetrofitFactory;
import com.example.ygagent.data.mapper.UserMapper;
import com.example.ygagent.data.remote.api.ApiResponse;
import com.example.ygagent.data.remote.api.AuthApi;
import com.example.ygagent.data.remote.dto.req.LoginReqDto;
import com.example.ygagent.data.remote.dto.resp.LoginRespDto;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.repository.UserRepository;

import java.io.IOException;

import retrofit2.Response;

public class UserRepositoryImpl implements UserRepository {

    public static final String TAG = "YG_UserRepositoryImpl";

    private final AuthApi authApi = RetrofitFactory.get().create(AuthApi.class);
    private final UserMapper mapper = new UserMapper();

    @Override
    public Result<User> login(LoginType loginType, String account, String password) {
        Log.d(TAG, "[test] login  #32");

        LoginReqDto reqDto = new LoginReqDto(loginType, account, password);

        Result<LoginRespDto> result = NetFactory.executeCall(() -> authApi.login(reqDto));

        if (!result.isSuccess()) {
            return Result.error(result.getError());
        }

        User user = mapper.toDomain(result.getData());

        return Result.success(user);
    }

}
