package com.example.ygagent.data.remote.api;

import com.example.ygagent.data.remote.dto.req.LoginReqDto;
import com.example.ygagent.data.remote.dto.resp.LoginRespDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("user/login")
    Call<ApiResponse<LoginRespDto>> login(@Body LoginReqDto reqDto);

}
