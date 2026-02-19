package com.example.ygagent.data.remote.api;

import com.example.ygagent.data.remote.dto.req.SearchSchoolReqDto;
import com.example.ygagent.data.remote.dto.resp.SearchSchoolRespDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SchoolApi {
    @POST("school/search")
    Call<ApiResponse<List<SearchSchoolRespDto>>> searchSchool(@Body SearchSchoolReqDto reqDto);
}
