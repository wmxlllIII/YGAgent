package com.example.ygagent.model.api;

import com.example.ygagent.model.dto.base.ApiResponse;
import com.example.ygagent.model.dto.resp.LoginDto;
import com.example.ygagent.model.dto.req.LoginReq;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/auth/login")
    Call<ApiResponse<LoginDto>> login(@Body LoginReq req);
}
