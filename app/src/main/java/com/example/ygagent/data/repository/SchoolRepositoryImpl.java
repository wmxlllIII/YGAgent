package com.example.ygagent.data.repository;

import android.util.Log;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.core.network.RetrofitFactory;
import com.example.ygagent.data.mapper.SchoolMapper;
import com.example.ygagent.data.remote.api.ApiResponse;
import com.example.ygagent.data.remote.api.SchoolApi;
import com.example.ygagent.data.remote.dto.req.SearchSchoolReqDto;
import com.example.ygagent.data.remote.dto.resp.SearchSchoolRespDto;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.domain.repository.SchoolRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class SchoolRepositoryImpl implements SchoolRepository {


    public static final String TAG = "YG_SchoolRepositoryImpl";
    private final SchoolApi schoolApi = RetrofitFactory.get().create(SchoolApi.class);
    private final SchoolMapper mapper = new SchoolMapper();

    @Override
    public Result<List<School>> search(String keyword) {
        try {
            Response<ApiResponse<List<SearchSchoolRespDto>>> response =
                    schoolApi.searchSchool(new SearchSchoolReqDto(keyword)).execute();

            if (!response.isSuccessful() || response.body() == null) {
                return Result.error("网络异常");
            }

            List<SearchSchoolRespDto> dtoList = response.body().getData();
            if (dtoList.isEmpty()) {
                Log.d(TAG, "[x] search #40");
                return Result.error("没有搜索结果");
            }

            List<School> result = new ArrayList<>();
            dtoList.forEach(dto -> result.add(mapper.toDomain(dto)));


            return Result.success(result);
        } catch (IOException e) {
            Log.d(TAG, "[x] search #50");
            return Result.error("网络异常");
        }
    }

    @Override
    public void refreshIfNeeded() {

    }
}
