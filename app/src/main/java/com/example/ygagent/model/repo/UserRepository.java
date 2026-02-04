package com.example.ygagent.model.repo;

import com.example.ygagent.model.api.ApiService;
import com.example.ygagent.model.dto.base.ApiResponse;
import com.example.ygagent.model.dto.req.LoginReq;
import com.example.ygagent.model.dto.resp.LoginDto;
import com.example.ygagent.model.net.RetrofitFactory;

import retrofit2.Callback;

public class UserRepository {

    private ApiService api = RetrofitFactory.get().create(ApiService.class);
    public void login(LoginReq req, Callback<ApiResponse<LoginDto>> cb){
        api.login(req).enqueue(cb);
    }
}
