package com.example.ygagent.data.repository;

import android.util.Log;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.core.network.NetFactory;
import com.example.ygagent.core.network.RetrofitFactory;
import com.example.ygagent.data.mapper.SchoolMapper;
import com.example.ygagent.data.remote.api.ApiResponse;
import com.example.ygagent.data.remote.api.SchoolApi;
import com.example.ygagent.data.remote.dto.req.SearchSchoolReqDto;
import com.example.ygagent.data.remote.dto.req.UpdateSchoolReqDto;
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
        Log.d(TAG, "[test] search");

        Result<List<SearchSchoolRespDto>> result = NetFactory.executeCall(
                () -> schoolApi.searchSchool(new SearchSchoolReqDto(keyword))
        );

        if (!result.isSuccess()) {
            return Result.error(result.getError());
        }

        List<SearchSchoolRespDto> dtoList = result.getData();

        if (dtoList == null || dtoList.isEmpty()) {
            Log.d(TAG, "[x] search #40");
            return Result.error("没有搜索结果");
        }

        List<School> schoolList = new ArrayList<>();
        dtoList.forEach(dto -> schoolList.add(mapper.toDomain(dto)));

        return Result.success(schoolList);
    }

    public Result<Boolean> updateSchool(School school) {
        Log.d(TAG, "[test] updateSchool");

        Result<Void> result = NetFactory.executeCall(
                () -> schoolApi.updateSchool(new UpdateSchoolReqDto(
                        school.getId(),
                        school.getName(),
                        school.getProvince(),
                        school.getCity()
                ))
        );

        if (!result.isSuccess()) {
            return Result.error(result.getError());
        }

        return Result.success(true);
    }

    @Override
    public void refreshIfNeeded() {

    }
}
